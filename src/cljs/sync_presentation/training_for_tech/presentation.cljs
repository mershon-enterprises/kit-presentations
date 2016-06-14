(ns sync-presentation.training-for-tech.presentation
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]))

(defcomponent slide-1
  [data :- {} owner]
  (render
    [_]
    (when (= 1 (:current-index data))
      (d/div
        (d/h1 "Training for Technology Skills")
        (d/h2 "Alyssa Haerle")
        (d/h2 "Kern Innovation & Technology")))))

(defcomponent slide-2
  [data :- {} owner]
  (render
    [_]
    (when (= 2 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "What's the issue with tech adoption in Kern County?")
        (d/h3 "Possible reasons")
        (d/ol
          (d/li "Kern County doesn't have the talent")
          (d/li "Kern County was slow to adopt")
          (d/li "Kern County can't retain its talent")
          (d/li "What issue???"))))))

(defcomponent slide-3
  [data :- {} owner]
  (render
    [_]
    (when (= 3 (:current-index data))
      (d/div {:style {:text-align "center"}}
        (d/h1 {:class "left"} "Kern County doesn't have the talent")
        (d/h3 "Programmers by County (2012 US Census)")
        (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/programmers-by-county-california.png"})))))

(defcomponent slide-4
  [data :- {} owner]
  (render
    [_]
    (when (= 4 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Kern County was slow to adopt")
        (d/h3 "Difficult to prove. All roads lead to finger-pointing...")
        (d/ul
          (d/li "Education System")
          (d/li "Lack of transportation infrastructure")
          (d/li "Lack of big tech players creating here"
                (d/ul
                  (d/li "They've been slow to adopt " (d/strong (d/em "us"))))))))))

(defcomponent slide-5
  [data :- {} owner]
  (render
    [_]
    (when (= 5 (:current-index data))
      (d/div {:style {:text-align "center"}}
        (d/h1 {:class "left"} "Kern County was slow to adopt")
        (d/h3 "Fresno was slow to adopt, too. Now they have this:")
        (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/bitwise-south-stadium.png"})
        (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/bitwise-ecosystem.png"})))))

(defcomponent slide-6
  [data :- {} owner]
  (render
    [_]
    (when (= 6 (:current-index data))
      (d/div {:style {:text-align "center"}}
        (d/h1 {:class "left"} "Kern County can't retain its talent")
        (d/h3 "Junior Developers")
        (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/rates-west-coast-juniors.png"})))))

(defcomponent slide-7
  [data :- {} owner]
  (render
    [_]
    (when (= 7 (:current-index data))
      (d/div {:style {:text-align "center"}}
        (d/h1 {:class "left"} "Kern County can't retain its talent")
        (d/h3 "Mid-to-Senior Developers")
        (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/rates-west-coast-seniors.png"})))))

(defcomponent slide-8
  [data :- {} owner]
  (render
    [_]
    (when (= 8 (:current-index data))
      (d/div {:style {:text-align "center"}}
        (d/h1 {:class "left"} "Kern County can't retain its talent")
        (d/h3 "Very Senior Developers")
        (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/rates-west-coast-very-seniors.png"})))))

(defcomponent slide-9
  [data :- {} owner]
  (render
    [_]
    (when (= 9 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "What issue???")
        (d/ul
          (d/li "The fact is, we " (d/strong (d/em "have")) " technology here.")
          (d/li "It looks different.")
          (d/li "It's built around industries currently suffering"))))))

(defcomponent presentation-components
 [data :- {} owner]
 (render
   [_]
   (d/div
     (om/build slide-1  (:slides data))
     (om/build slide-2  (:slides data))
     (om/build slide-3  (:slides data))
     (om/build slide-4  (:slides data))
     (om/build slide-5  (:slides data))
     (om/build slide-6  (:slides data))
     (om/build slide-7  (:slides data))
     (om/build slide-8  (:slides data))
     (om/build slide-9  (:slides data)))))
