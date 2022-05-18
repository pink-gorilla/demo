
(ns page.greeter
  (:require 
    [user :refer [add-page-site]]))

(defn greeter-details-page [route-data]
  [:div
   [:p "this shows how to do master-detail relations"]
   [:p "Access this component only via greeter."]
   [:p.bg-blue-300.mg-3 "the best dad in the world is: " (pr-str route-data)]])

(add-page-site greeter-details-page :demo-greeter-details)

(def prefix "yes: ")

(defn greeter-page [route-data]
  (let [state (r/atom {:in ""
                       :msg "Type Something..."})
        change-state (fn [s e]
                       (swap! state
                              (assoc s :in (:value e)
                                     :msg (str prefix ", " (:value e)))))]
    (fn []
      [:div.rows
       [:input {:class "border border-blue-300"
                :type "text"
                :on-change #(change-state % "Hello")
                :value (:in @state)}]
       [:a {:href (str "/system/greeter-details/" (:in @state))}
        [:p.m-2.p-1.border.border-round (str "goto person: " (:in @state))]]
       [:div.text-2xl (:msg @state)]])))

(add-page-site greeter-page :demo-greeter)



