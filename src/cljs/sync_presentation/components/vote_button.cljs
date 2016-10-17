(ns sync-presentation.components.vote-button
  (:require [clojure.walk :refer [keywordize-keys]]

            [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]

            [om-bootstrap.button :as b]

            [matchbox.core :as m]

            [sync-presentation.app-state :as app-state]))

(defn- update-chart!
  [slides]
  (let [presentation-name (keyword (:presentation-name slides))
        current-index     (keyword (str (:current-index slides)))
        data (clj->js (reduce-kv
                        (fn [m k v]
                          (conj m [k v]))
                        []
                        (get-in slides [:data presentation-name current-index])))

        structure #js {:bindto (str "#"
                                    (:presentation-name slides) "-"
                                    (:current-index slides))
                       :data  #js {:columns data
                                   :type    "pie"}}]
    (js/c3.generate structure)))

(defcomponent vote-button
  [label :- {} owner {:keys [slides presentation-name current-index] :as opts}]
  (render
    [_]
   (let [label-kwd     (keyword label)
         current-count (get-in slides [:data presentation-name current-index label-kwd])]
     (b/button {:bs-style "info"
                :on-click (fn []
                            (m/reset-in! app-state/root [:slides :data presentation-name current-index label-kwd]
                                         (inc current-count))
                            (swap! app-state/state assoc-in [:voted? current-index] true)
                            (update-chart! (get-in @app-state/state [:slides])))}
               label))))

(defcomponent vote-chart
  [slides :- {} owner]
  (did-mount
    [_]
    (update-chart! (om/observe owner (app-state/slides))))
  (render-state
    [_ {:keys [slides]}]
    ; show chart always
    (d/div {:class "chart"
            :id (str (:presentation-name slides) "-"
                     (:current-index slides))})))

(defcomponent vote-group
  [labels :- {} owner]

  (render
    [_]
    (let [slides            (om/observe owner (app-state/slides))
          presentation-name (keyword (:presentation-name slides))
          current-index     (keyword (str (:current-index slides)))
          voted?            (om/observe owner (app-state/voted?))]
      (d/div {:class "text-center"}
             (om/build vote-chart {} {:state {:slides slides}})

             (if-not (or (app-state/is-presenter?)
                         (get voted? current-index))

               ; is not presenter and has not voted
               (b/button-group
                 {}
                 (om/build-all vote-button labels {:opts {:slides            slides
                                                          :presentation-name presentation-name
                                                          :current-index     current-index}})))))))
