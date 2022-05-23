
(ns page.greeter
  (:require
   [reagent.core :as r]
   [re-frame.core :as rf]
   [lib.ui :refer [add-page-site]]))

(defn greeter-details-page [route-data]
  [:div
   [:p "this shows how to do master-detail relations"]
   [:p "Access this component only via greeter."]
   [:p.bg-blue-300.mg-3 "the best dad in the world is: " (pr-str route-data)]])

(add-page-site greeter-details-page :demo-greeter-details)

(def prefix "Hello, ")

(defn greeter-page [route-data]
  (let [state (r/atom {:name ""
                       :msg "Type Something..."})
        change-state (fn [e & args]
                       (let [t (.-target e)
                             v (.-value t)]
                         (.log js/console e args)
                         (swap! state assoc :name v)))]
    (fn [route-data]
      [:div.rows
       [:input {:class "border border-blue-300"
                :type "text"
                :on-change change-state
                :value (:name @state)}]
       [:a {:on-click #(rf/dispatch [:bidi/goto :demo-greeter-details :query-params {:name (:name @state)}])}
        [:p.m-2.p-1.border.border-round (str "goto person: " (:name @state))]]
       [:div.text-2xl (str "Hello, " (:name @state))]])))

(add-page-site greeter-page :demo-greeter)



