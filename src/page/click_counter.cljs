(ns page.click-counter
  (:require
   [reagent.core :as r]
   [lib.ui :refer [add-page-site]]))

(defn click-counter-page [route-data]
  (let [state (r/atom 42)]
    (fn [route-data]
      [:div "Clicked "
       [:button {:class "border m-2 p-3 border-pink-500 text-xl"
                 :on-click #(swap! state inc)}
        @state]
       " times"])))

(add-page-site click-counter-page :demo-click-counter)