(ns sync-presentation.app-state
  (:require [clojure.walk :refer [keywordize-keys]]

            [om.core :as om :include-macros true]

            [matchbox.core :as m]))

(defonce state (atom {:slides {:current-index 0
                               :presentation-name nil
                               :data {}}
                      :data {}
                      :is-presenter? false
                      :voted? {}}))

(defonce root (m/connect "https://mec-presentation.firebaseio.com"))
(m/auth-anon root)

(m/listen-children
  root [:slides]
  (fn [[event-type data]]
    (let [mapped (keywordize-keys (apply array-map data))]
      ; update the slide data
      (swap! state assoc-in [:slides (first (keys mapped))] (first (vals mapped))))))

(defn is-presenter?
  []
  (:is-presenter? @state))

(defn voted?
  []
  (om/ref-cursor (:voted? (om/root-cursor state))))

(defn slides
  []
  (om/ref-cursor (:slides (om/root-cursor state))))
