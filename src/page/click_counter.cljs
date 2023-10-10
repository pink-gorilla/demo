(ns page.click-counter
  (:require
   [reagent.core :as r]
   [lib.ui :refer [wrap-page-site]]))

(defn click-counter-page [_route-data]
  (let [state (r/atom 42)]
    (fn [_route-data]
      [:div "Clicked "
       [:button {:class "border m-2 p-3 border-pink-500 text-xl"
                 :on-click #(swap! state inc)}
        @state]
       " times"])))

(def click-counter-page-wrapped (wrap-page-site click-counter-page))

