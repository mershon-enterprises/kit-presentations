(ns sync-presentation.core
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]
            [om-bootstrap.button :as b]
            [om-bootstrap.grid :as g]
            [matchbox.core :as m]
            [clojure.walk :refer [keywordize-keys]]

            [sync-presentation.app-state :as app-state]

            [sync-presentation.best-tool.presentation :as best-tool]
            [sync-presentation.training-for-tech.presentation :as training-for-tech]
            [sync-presentation.kit-2020.presentation :as kit-2020]
            ))

(enable-console-print!)

(defonce root (m/connect "https://mec-presentation.firebaseio.com"))
(m/auth-anon root)


(m/listen-children
  root [:slides]
  (fn [[event-type data]]
    (let [mapped (keywordize-keys (apply array-map data))]
      ; update the slide index
      (swap! app-state/state assoc-in [:slides (first (keys mapped))] (first (vals mapped))))))

(defcomponent prev-button
  [data :- {} owner]
  (render
    [_]
    (when true
      (b/button {:bs-style "info"
                 :on-click (fn []
                             (let [current-index (get-in @app-state/state [:slides :current-index])]
                               (m/reset-in! root [:slides :current-index] (dec current-index))))}
                "Prev"))))
(defcomponent next-button
  [data :- {} owner]
  (render
    [_]
    (when true
      (b/button {:bs-style "info"
                 :on-click (fn []
                             (let [current-index (get-in @app-state/state [:slides :current-index])]
                               (m/reset-in! root [:slides :current-index] (inc current-index))))}
                "Next"))))


(defcomponent root-component
  [data :- {} owner]
  (will-mount
    [_]
    (when (not= -1 (.indexOf js/window.location.search "presenter"))
      (swap! app-state/state assoc :is-presenter? true)))
  (render
    [_]
    (if-let [presentation-name (get-in data [:slides :presentation-name])]
      (d/div
        (case presentation-name

          "best-tool"
          (om/build best-tool/presentation-components data)

          "training-for-tech"
          (om/build training-for-tech/presentation-components data)

          "kit-2020"
          (om/build kit-2020/presentation-components data))

        (when
          (:is-presenter? @app-state/state)
          (g/grid {}
                  (g/row {}
                         (g/col {:id "prev-button"
                                 :xs 4}
                                (om/build prev-button nil))
                         (g/col {:id "next-button"
                                 :xs-offset 4 :xs 4}
                                (om/build next-button nil))))))

      (d/h4 "No presentation is currently selected."))))

(om/root
 root-component
 app-state/state
 {:target (. js/document (getElementById "app"))})
