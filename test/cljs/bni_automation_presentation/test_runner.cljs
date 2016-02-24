(ns bni-automation-presentation.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [bni-automation-presentation.core-test]))

(enable-console-print!)

(doo-tests 'bni-automation-presentation.core-test)
