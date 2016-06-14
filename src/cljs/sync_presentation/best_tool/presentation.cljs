(ns sync-presentation.best-tool.presentation
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]))

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

(defcomponent slide-9
  [data :- {} owner]
  (render
    [_]
    (when (= 9 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "What does efficiency in my business look like?")
        (d/ul
          (d/li (d/u (d/b "AUTOMATION")) " - computers are literally thousands of times faster than we are.")
          (d/li "Some freebies!"
                (d/ul
                  (d/li "no time sheets"
                        (d/ul
                          (d/li "Find a way to get rid of the time sheet as a paradigm of your business.")
                          (d/li "I'm not saying put everyone on salary, but there are tons of alternative solutions to get you away from printed/digital time sheets to run payroll.")
                          (d/li "Clock-in/clock-out systems which track by project digitally and auto-compile your payroll is the way to go.")
                          (d/li "The best options allow you to enter time as you go, and also allow you or management to bulk-enter time retroactively.")))
                  (d/li "automate your expenses and mileage logs"
                        (d/ul
                          (d/li "most credit cards auto-categorize expenses.")
                          (d/li "At minimum your banking ledger should be connected to your accounting or ERP software to pull in and reconcile transactions for monitoring.")
                          (d/li "Mileage logs should be completely automated. There's no excuse not to, with smartphones with GPS everywhere.")
                          ))
                  (d/li "no duplication of data or data entry")))

          (d/li "all of this data collected can be used to ask questions about your business and help you keep down your costs")
          (d/li "It " (d/u (d/b "is possible")) " for you to know every single day how much your business costs to run."))))))

(defcomponent slide-10
  [data :- {} owner]
  (render
    [_]
    (when (= 10 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "The Cost Fallacy")
        (d/ul
          (d/li "First thing everyone thinks when they hear automation: " (d/i "How much is this going to cost?"))
          (d/li "Generally speaking, the initial cost to automate some piece of your business will be about the same as the people who are currently doing the work already cost you. " (d/u (d/b "ONCE.")))
          (d/li "Executed well, over a sufficiently long period of time, that can amount to 90% savings or better, with a few assumptions entirely within your control:"
                (d/ul
                  (d/li "whatever you're automating needs to be 100% logically consistent. Minimize the " (d/i "\"But sometimes...\"") " conditions.")
                  (d/li "you're forthright and good about communicating feedback to your software vendor")
                  (d/li "you're willing to experiment with your solution to tailor it to your needs while it is still being developed"))))))))

(defcomponent slide-11
  [data :- {} owner]
  (render
    [_]
    (when (= 11 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Scenario 1: No Automation")
        (d/ul
          (d/li "2 clerical staff at $11/hr")
          (d/li "Costs me ~$46k/year, no benefits, no expenses to keep my location")
          (d/li "Optimistic: workload for this business unit to grow 20% year-over-year, for the next 10")
          (d/li "As demand grows, I have to hire to compensate for their workload.")
          (d/li "Assuming I never give raises, minimum wage never goes up, taxes don't get raised, and I can hire everyone new at the exact same rate, I have to hire in years 4, 5, 7, two in year 8, year 9, and two more in year 10")
          (d/li "Total out of pocket is in the neighborhood of $1.08M")
          (d/li "This assumes no office expansion, no new furniture to seat them, no manager to run this burgeoning team...")
          (d/li "This is pretty much " (d/b "best") " case scenario."))))))

(defcomponent slide-12
  [data :- {} owner]
  (render
    [_]
    (when (= 12 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Scenario 2: " (d/i "Yes") " Automation")
        (d/ul
          (d/li "2 clerical staff at $11/hr")
          (d/li "Costs me ~$46k/year, no benefits, no expenses to keep my location")
          (d/li "Optimistic: workload for this business unit to grow 20% year-over-year, for the next 10")
          (d/li "In year 1, I run a project to automate my business unit for $46k, and never have to hire again.")
          (d/li "I decide to keep my team, and assign them to quality control and customer service, and give them 2% raise each year")
          (d/li "But...I go " (d/b "100% over budget") ". Whoops.")
          (d/li "And, I'm going to " (d/b "rewrite the whole system, every other year") " due to changes in legislation or internal dynamics of the company.")
          (d/li "Total out of pocket, ~$776k")
          (d/li "This is pretty much " (d/b "worst") " case scenario."))))))

(defcomponent slide-13
  [data :- {} owner]
  (render
    [_]
    (when (= 13 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Too good to be true?")
        (d/ul
          (d/li "You cannot look outside or even around this room and claim the landscape of business hasn't change. The rules today are different.")
          (d/li "As Internet pioneer Marc Andreessen said in 2011, " (d/i "Software is eating the world.") " (His net worth is upwards of $600M invested in tech. He knows a thing or two.")
          (d/li "Last year, every quarter, Apple was ranked #1 in global market value, with Google and Microsoft neck-and-neck behind them. Facebook was in the top 10 in the last quarter.")
          (d/li "You cannot be complacent. You cannot settle with what you have. You cannot fear change. Your competition is not, will not, and does not.")
          (d/li "Sooner or later, they will learn their " (d/i "ne waza") ", they will practice their " (d/i "happo no kuzushi ") (d/u (d/b "on you")) ", and they will mop the floor with you and leave you unemployed and "(d/u (d/b "unemployable"))"."))))))

(defcomponent slide-14
  [data :- {} owner]
  (render
    [_]
    (when (= 14 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "I'm here to help")
        (d/ul
          (d/li "This is where I can help. This is what I've been doing for 13 years. I design and implement business solutions to save your bottom line.")
          (d/li "I can make anything talk to anything. I can make computers work for people who insist they can't use computers. I can make software talk to software. I can make your cell phone talk to your refridgerator.")
          (d/li "Anything we can visualize, I can build, and I've got the team behind me to help me do it.")
          (d/li "Best of all, I'm not 250 miles away in a colorful office getting free daily massages. I'm here, with you, today.")
          (d/li "Ask yourself: What tools are you paying for, what could you do without, what sucks, what’s broken, what would be amazing if only for this or that, or what just cannot be done because the powers that be refuse to allow it?")
          (d/li "Eventually, something's going to give, and you're going to need to simplify, and automate. When you're ready, give me a call."))))))

(defcomponent slide-15
  [data :- {} owner]
  (render
    [_]
    (when (= 15 (:current-index data))
      (d/div
        (d/h1 {:class "left"} "Thank you for listening")
        (d/h3 {:class "left"} "Kevin Mershon, Mershon Enterprises")
        (d/h3 {:class "left"} "A Bakersfield software company, a name you know, a team you can count on.")
        (d/h3 {:class "left"} "(661) 425-9099")
        (d/h4 {:class "left"} "We are: 4 developers, 1 Alyssa, and a handful of consultants ready to get your project done")
        (d/h4 {:class "left"} "Websites, mobile apps, databases, applications, system architecture, and systems integration.")
        (d/h4 {:class "left"} "Industrial, agricultural, accounting, inventory, payroll, and HR.")
        ))))

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
     (om/build slide-10 (:slides data))
     (om/build slide-11 (:slides data))
     (om/build slide-12 (:slides data))
     (om/build slide-13 (:slides data))
     (om/build slide-14 (:slides data))
     (om/build slide-15 (:slides data)))))
