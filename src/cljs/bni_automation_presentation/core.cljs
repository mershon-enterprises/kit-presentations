(ns bni-automation-presentation.core
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]
            [matchbox.core :as m]))

(enable-console-print!)

(defonce root (m/connect "https://mec-bni-presentation.firebaseio.com"))
(m/auth-anon root)

(defonce app-state (atom {:slides {:current-index nil}}))

(m/listen-children
  root [:slides]
  (fn [[event-type data]]
    (let [mapped (apply array-map data)]
      ; update the slide index
      (swap! app-state assoc-in [:slides :current-index] (get mapped "current-index")))))

(defcomponent slide-1
  [data :- {} owner]
  (render
    [_]
    (when (= 1 (:current-index data))
      (d/div
        (d/h1 "The best tool for the job")
        (d/h2 "Kevin Mershon")
        (d/h2 "Mershon Enterprises")))))

(defcomponent slide-2
  [data :- {} owner]
  (render
    [_]
    (when (= 2 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Tools: Thoughts to take away")
        (d/h3 "In my talk \"Tools\", I left you with a handful of questions to ask yourself.")
        (d/ul
          (d/li "Are your tools important to you?")
          (d/li "Could you work without them?")
          (d/li "Are they brittle, or are they simple?")
          (d/li "Can anyone use them?")
          (d/li "Are they free, as in freedom?"))
        (d/h3 "But I left out the biggest question of all:")
        (d/h1 "Are the tools you're using the best for the job?")))))

(defcomponent slide-3
  [data :- {} owner]
  (render
    [_]
    (when (= 3 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Etymology: What is " (d/i "best") "?")
        (d/h3 {:class "left"} "3 (or maybe 4!) forms:")
        (d/ul
          (d/li "adjective: of the most excellent, effective or desirable type or quality"
                (d/ul (d/li "you're the " (d/i "best"))))
          (d/li "adverb: meaning \"well\""
                (d/ul (d/li "we did our " (d/i "best"))))
          (d/li "noun: \"that which is the most excellent, outstanding, or desirable\""
                (d/ul (d/li "this one is the " (d/i "best") " of the bunch")))
          (d/li "(informally) verb: outwit or get the better of (someone)"
                (d/ul (d/li "to " (d/i "best") " someone"))))

        (d/h3 "We usually don't mean the last one, but let's consider it...")))))
(defcomponent root-component
  [data :- {} owner]
  (render
    [_]
    (d/div
      (om/build slide-1 (:slides data))
      (om/build slide-2 (:slides data))
      (om/build slide-3 (:slides data))
      )))

(om/root
 root-component
 app-state
 {:target (. js/document (getElementById "app"))})
