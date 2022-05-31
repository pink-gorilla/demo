(ns page.time
  (:require
   [reagent.core :as r]
   [re-frame.core :as rf]
   [lib.ui :refer [add-page-site]]))

(defonce
  time-state (r/atom {:time "waiting for server time"}))

(rf/reg-event-fx
 :demo/time
 (fn [_ [_ msg]]
   (swap! time-state assoc :time msg)
   nil))

(defn time-ui []
  [:div.rows
   [:p.text-xl.text-blue-700 "This demo shows how to push data from the server."]
   [:p.text-xl.text-blue-700 "time is pushed every 10 seconds."]
   [:div (pr-str (:time @time-state))]])

(defn time-page [_route-data]
  [:div
   [:div.text-green-300 "time ui"]
   [time-ui]])

(add-page-site time-page :user/time)