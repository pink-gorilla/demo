(ns page.countdown
  (:require
   [reagent.core :as r]
   [lib.ui :refer [wrap-page-site]]))

(defn countdown-page [_route-data]
  (let [state (r/atom 0)]
    (fn [_route-data]
      (js/timeout #(swap! state inc) 1000)
      [:div
       "Seconds Elapsed: "
       @state])))

(def countdown-page-wrapped (wrap-page-site countdown-page))