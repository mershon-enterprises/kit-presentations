(ns sync-presentation.kit-2020.presentation
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]

            [sync-presentation.components.vote-button :refer [vote-group]]
            ))

(defcomponent slide-1
  [data :- {} owner]
  (render
    [_]
    (when (= 1 (:current-index data))
      (d/div
        (d/h1 "KIT 2020")
        (d/h2 "Kevin Mershon")
        (d/h2 "Kern Innovation & Technology")
        (d/p {:class "text-center"} "Follow along at http://slides.followthefox.org")))))

(defcomponent slide-2
  [data :- {} owner]
  (render
    [_]
    (when (= 2 (:current-index data))
      (d/div
        (d/h1 "First, a quick survey:")
        (d/h3 "What Major are you?")
        (om/build vote-group ["Comp Eng" "Comp Sci" "Math" "Physics" "Other"]))
      )))

(defcomponent presentation-components
 [data :- {} owner]
 (render
   [_]
   (d/div
     (om/build slide-1  (:slides data))
     (om/build slide-2  (:slides data))
     )))
