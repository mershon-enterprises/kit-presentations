(ns sync-presentation.components.vote-button
  (:require [clojure.walk :refer [keywordize-keys]]

            [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]

            [om-bootstrap.button :as b]

            [matchbox.core :as m]

            [sync-presentation.app-state :as app-state]))

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
                            (swap! app-state/state assoc-in [:voted? current-index] true))}
               label))))

(defcomponent vote-group
  [labels :- {} owner]
  (render
    [_]
    (let [slides            (om/observe owner (app-state/slides))
          presentation-name (keyword (:presentation-name slides))
          current-index     (keyword (str (:current-index slides)))
          voted? (om/observe owner (app-state/voted?))]
      (d/div {:class "text-center"}
             (if-not (get voted? current-index)
               (b/button-group
                 {}
                 (om/build-all vote-button labels {:opts {:slides            slides
                                                          :presentation-name presentation-name
                                                          :current-index     current-index}}))
               (d/table
                 (d/tr
                   (map #(d/th (name %)) (keys (get-in slides [:data presentation-name current-index]))))
                 (d/tr
                   (map #(d/td %) (vals (get-in slides [:data presentation-name current-index]))))
                 ))))))
