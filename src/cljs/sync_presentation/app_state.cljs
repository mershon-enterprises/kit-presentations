(ns sync-presentation.app-state)

(defonce state (atom {:slides {:current-index 0
                               :presentation-name nil}
                      :is-presenter? false}))
