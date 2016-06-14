(ns sync-presentation.core
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]
            [om-bootstrap.button :as b]
            [om-bootstrap.grid :as g]
            [matchbox.core :as m]
            [clojure.walk :refer [keywordize-keys]]

            [sync-presentation.best-tool.presentation :as best-tool]
            [sync-presentation.training-for-tech.presentation :as training-for-tech]
            ))

(enable-console-print!)

(defonce root (m/connect "https://sync-presentation.firebaseio.com"))
(m/auth-anon root)

(defonce app-state (atom {:slides {:current-index 0
                                   :presentation-name nil}}))

(m/listen-children
  root [:slides]
  (fn [[event-type data]]
    (let [mapped (keywordize-keys (apply array-map data))]
      ; update the slide index
      (swap! app-state assoc-in [:slides (first (keys mapped))] (first (vals mapped))))))

(defcomponent prev-button
  [data :- {} owner]
  (render
    [_]
    (when true
      (b/button {:bs-style "info"
                 :on-click (fn []
                             (let [current-index (get-in @app-state [:slides :current-index])]
                               (m/reset-in! root [:slides :current-index] (dec current-index))))}
                "Prev"))))
(defcomponent next-button
  [data :- {} owner]
  (render
    [_]
    (when true
      (b/button {:bs-style "info"
                 :on-click (fn []
                             (let [current-index (get-in @app-state [:slides :current-index])]
                               (m/reset-in! root [:slides :current-index] (inc current-index))))}
                "Next"))))


(defcomponent root-component
  [data :- {} owner]
  (render
    [_]
    (d/div
      (case (:presentation-name (:slides data))

        "best-tool"
        (om/build best-tool/presentation-components data)

        "training-for-tech"
        (om/build training-for-tech/presentation-components data))

      (when
        (not= -1 (.indexOf js/window.location.search "presenter"))
        (g/grid {}
                (g/row {}
                       (g/col {:id "prev-button"
                               :xs 4}
                              (om/build prev-button nil))
                       (g/col {:id "next-button"
                               :xs-offset 4 :xs 4}
                              (om/build next-button nil))))))))

(om/root
 root-component
 app-state
 {:target (. js/document (getElementById "app"))})
