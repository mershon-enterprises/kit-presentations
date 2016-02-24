(ns bni-automation-presentation.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [matchbox.core :as m]))

(enable-console-print!)

(defonce root (m/connect "https://mec-bni-presentation.firebaseio.com"))
(m/auth-anon root)

(defonce app-state (atom {:slides {:current-index 1}}))

(m/listen-children
  root [:slides]
  (fn [[event-type data]]
    (let [mapped (apply array-map data)]
      ; update the slide index
      (swap! app-state assoc-in [:slides :current-index] (get mapped "current-index")))))

(defn root-component [app owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil (dom/h1 nil (str "Slide " (get-in app [:slides :current-index])))))))

(om/root
 root-component
 app-state
 {:target (. js/document (getElementById "app"))})
