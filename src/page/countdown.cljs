(ns page.countdown
  (:require
   [reagent.core :as r]
   [goldly.js :refer [timeout]]
   [lib.ui :refer [add-page-site]]))

(defn countdown-page [_route-data]
  (let [state (r/atom 0)]
    (fn [_route-data]
      (timeout #(swap! state inc) 1000)
      [:div
       "Seconds Elapsed: "
       @state])))

(add-page-site countdown-page :demo-countdown)