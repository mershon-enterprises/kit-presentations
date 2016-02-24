(ns bni-automation-presentation.core
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]
            [om-bootstrap.button :as b]
            [om-bootstrap.grid :as g]
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

(defcomponent slide-4
  [data :- {} owner]
  (render
    [_]
    (when (= 4 (:current-index data))
      (d/div
        (d/h1 {:class "left"} (d/i "Best") "ing, as a verb")
        (d/ul
          (d/li "Besting implies that you're in competition or combat with someone")
          (d/li "We all have competitors, vendors, customers...")
          (d/li "Lots of authors have made the comparison of business to war (nonexhaustive):"
                (d/ul
                  (d/li "Sun Tzu, the Art of War")
                  (d/li "Machiavelli, The Prince")
                  (d/li "Adam Smith, The Wealth of Nations")
                  (d/li "Ayn Rand, Atlas Shrugged")))
          (d/li "I'm also going to suggest"
                (d/ul
                  (d/li "Robert Greene, The 48 Laws of Power"))))))))

(defcomponent slide-5
  [data :- {} owner]
  (render
    [_]
    (when (= 5 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "The 48 Laws, in ~30 seconds")
        (d/ul
          (d/li "In Green's own words, the book is \"a distillation of accumulated wisdom gathered from writing of the most illustrious strategists, statesmen, courtiers, seducers, and con artists in history, spanning more than 3 thousand years across numerous civilizations\"")
          (d/li "This book is, in a word, " (d/u (d/b "EVIL")))
          (d/li "BUT, we can all learn something from it and so today I'm going to focus on the binding theme this book constantly circles back to, in order to teach you how to " (d/i "best") " others in the game of power: the art of " (d/u (d/b "indirection"))))))))

(defcomponent slide-6
  [data :- {} owner]
  (render
    [_]
    (when (= 6 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Judo, in ~60 seconds")
        (d/ul
          (d/li "The inventor of Judo, Jigoro Kano as a kid was bullied and sought out Jujutsu to train, couldn’t find a teacher for quite some time, and discovered that it was kind of being pushed out of existence by westernization and the high competitiveness and occasional brutality of the sport.")
          (d/li "When he finally did find a teacher, a " (d/i "sensei") ", he found one who emphasized application of techniques over exercise (e.g. more real-world)")
          (d/li "As an adult in 1882, as jujutsu continued to lose popularity nation-wide and the discipline was being lost, Kano decided to reject techniques which were inefficient or self-destructive (like a flying scissor kick), and focus on a simpler core so he created Judo, which means “the gentle way” (or more appropriately, the " (d/u (d/b "efficient")) " way)"))))))

(defcomponent slide-7
  [data :- {} owner]
  (render
    [_]
    (when (= 7 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "My off-balanced job")
        (d/ul
          (d/li "Anyone ever ask their spouse how their day was? It usually goes like this:"
                (d/ul
                  (d/li "we're busy")
                  (d/li "everyone has different goals")
                  (d/li "we're constantly focused on not going over on labor")
                  (d/li "sometimes we're understaffed and overworked")
                  (d/li "there are constant communication issues")
                  (d/li "there is gossip, and internal politics")
                  (d/li "all of this, while we're trying to please our choosy customers")))
          (d/li "This is probably true about every business represented in this room")
          (d/li "A great quote my sister once told me"
                (d/ul
                  (d/li (d/i "It's like kite-surfing. You're always falling to one side and then overcorrecting. The only thing you care about is not falling in.")))))))))

(defcomponent slide-8
  [data :- {} owner]
  (render
    [_]
    (when (= 8 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Tenants of Judo we can apply to business")
        (d/ul
          (d/li "randori"
                (d/ul
                  (d/li "free practice")
                  (d/li "All business processes have a human element to them that we must come to accept, and that means we must be pragmatic in our approach and responsive to its effects.")
                  (d/li "Sun-Tzu said: " (d/i "\"Move swift as the Wind and closely-formed as the Wood. Attack like the Fire and be still as the Mountain.\""))
                  (d/li "always test yourself with the tools and techniques you've learned. " (d/u (d/b "KNOW")) " how to use them")))
          (d/li "happo no kuzushi (" (d/i "ne waza") "/standing technique)"
                (d/ul
                  (d/li "the 8 directions of off-balancing (the art of " (d/u (d/b "indirection")) ")"))
                  (d/li "Sun-Tzu said: " (d/i "\"The greatest victory is that which requires no battle.\""))
                  (d/li "Use the least amount of effort to exact the greatest effect.")))))))



(defcomponent root-component
  [data :- {} owner]
  (render
    [_]
    (d/div
      (om/build slide-1 (:slides data))
      (om/build slide-2 (:slides data))
      (om/build slide-3 (:slides data))
      (om/build slide-4 (:slides data))
      (om/build slide-5 (:slides data))
      (om/build slide-6 (:slides data))
      (om/build slide-7 (:slides data))
      (om/build slide-8 (:slides data))
      (g/grid {}
        (g/row {}
               (g/col {:xs 4}
                      (om/build prev-button nil))
               (g/col {:xs-offset 4 :xs 4}
                      (om/build next-button nil)))))))

(om/root
 root-component
 app-state
 {:target (. js/document (getElementById "app"))})
