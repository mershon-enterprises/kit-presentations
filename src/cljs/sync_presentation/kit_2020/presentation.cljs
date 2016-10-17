(ns sync-presentation.kit-2020.presentation
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]))

(defcomponent slide-1
  [data :- {} owner]
  (render
    [_]
    (when (= 1 (:current-index data))
      (d/div
        (d/h1 "KIT 2020")
        (d/h2 "Kevin Mershon")
        (d/h2 "Kern Innovation & Technology")))))

(defcomponent presentation-components
 [data :- {} owner]
 (render
   [_]
   (d/div
     (om/build slide-1  (:slides data))
     )))
