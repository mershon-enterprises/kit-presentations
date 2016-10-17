(ns sync-presentation.kit-2020.presentation
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]

            [om-bootstrap.grid :as g]

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
        (om/build vote-group ["Comp Eng" "Comp Sci" "Math" "Physics" "Other"])))))

(defcomponent slide-3
  [data :- {} owner]
  (render
    [_]
    (when (= 3 (:current-index data))
      (d/div
        (d/h3 "Who are we?")
        (d/ul
          (d/li "KIT - Kern Innovation & Technology"
                (d/ul
                  (d/li "Mershon Enterprises - Software Consultancy")
                  (d/li "Ponce de Leon Enterprises - Logistics / PMI")
                  (d/li "Other sponsors"
                        (d/ul
                          (d/li "ARRC Technology")
                          (d/li "iSafetyPro")
                          (d/li "CAPK")
                          (d/li "etc."))))))))))

(defcomponent slide-4
  [data :- {} owner]
  (render
    [_]
    (when (= 4 (:current-index data))
      (d/div
        (d/h3 "What is our goal?")
        (d/p (d/em "The KIT Community is a community organization building an active,
                   prosperous tech and innovation community in Kern County. KIT is a
                   local resource in the tech community for those seeking to learn about,
                   explore, and build their own technology and technology startups."))))))

(defcomponent slide-5
  [data :- {} owner]
  (render
    [_]
    (when (= 5 (:current-index data))
      (d/div
        (d/h3 "What do we do? - Part 1")
        (d/h4 "Hackathons")
        (d/h5 "Tech Fighting the Wildfires Hackathon")
        (g/grid {:class "text-center"}
                (g/row {}
                       (g/col {:xs 12}
                              (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/tech-ftw-1.jpg"}))
                      (g/col {:xs 12}
                              (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/tech-ftw-2.jpg"}))))))))

(defcomponent slide-6
  [data :- {} owner]
  (render
    [_]
    (when (= 6 (:current-index data))
      (d/div
        (d/h3 "What do we do? - Part 2")
        (d/h4 "Contests")
        (d/h5 "Kids Drawing Context (Draw the Fox!)")
        (g/grid {:class "text-center"}
                (g/row {}
                       (g/col {:xs 6}
                              (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/drawing-contest-1.jpg"}))
                       (g/col {:xs 6}
                              (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/drawing-contest-2.jpg"}))))))))
(defcomponent slide-7
  [data :- {} owner]
  (render
    [_]
    (when (= 7 (:current-index data))
      (d/div
        (d/h3 "What do we do? - Part 3")
        (d/h4 "Meetups")
        (d/h5 "Bakersfield Startup Meetup at MESH Cowork")
        (g/grid {:class "text-center"}
                (g/row {}
                       (g/col {:xs 12}
                              (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/meetups-1.jpg"}))
                       ))))))
(defcomponent slide-8
  [data :- {} owner]
  (render
    [_]
    (when (= 8 (:current-index data))
      (d/div
        (d/h3 "What do we do? - Part 4")
        (d/h4 "Community Outreach")
        (d/h5 "Monthly Think Tank")
        (g/grid {:class "text-center"}
                (g/row {}
                       (g/col {:xs 12}
                              (d/img {:src "https://s3-us-west-2.amazonaws.com/kern-innovation-and-technology/community-outreach.jpg"}))
                       ))))))
(defcomponent slide-9
  [data :- {} owner]
  (render
    [_]
    (when (= 9 (:current-index data))
      (d/div
        (d/h3 "Where are we headed?")
        (d/ul
          (d/li "Electric Bookworm Hackathon - November 18-20")
          (d/li "Bakersfield College Public Health Hackathon - April '17")
          (d/li "Working with Beale Library to foster Coding Club")
          (d/li "KIT 2020 Plan..."))))))

(defcomponent slide-10
  [data :- {} owner]
  (render
    [_]
    (when (= 10 (:current-index data))
      (d/div
        (d/h3 "KIT 2020 Plan")
        (d/h5 "Only 3 years, really...")
        (d/ul
          (d/li "100 LOCAL Tech Startups")
          (d/li "Employing 300 Residents")
          (d/li "Funded by 25 local investors")
          (d/li "With 50 overall deals closed"))))))

(defcomponent slide-11
  [data :- {} owner]
  (render
    [_]
    (when (= 11 (:current-index data))
      (d/div
        (d/h3 "How can you help?")
        (d/ul
          (d/li "Start a Startup!")
          (d/li "Volunteer!")
          (d/li "Attend Local Events")
          (d/li "Tell your friends!"))))))

(defcomponent slide-12
  [data :- {} owner]
  (render
    [_]
    (when (= 12 (:current-index data))
      (d/div {:class "text-center"}
        (d/h1 "Thank you for listening")
        (d/h3 "Kevin Mershon, Mershon Enterprises (& KIT)")
        (d/h3 "Follow the Fox")
        (d/h3 "www.followthefox.org")))))

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
     (om/build slide-9  (:slides data))
     (om/build slide-10  (:slides data))
     (om/build slide-11  (:slides data))
     (om/build slide-12  (:slides data))
     )))
