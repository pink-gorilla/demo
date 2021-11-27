

(defonce
  time-state (r/atom {:time "waiting for server time"}))

(rf/reg-event-fx
 :demo/time
 (fn [{:keys [db]} [_ msg]]
   (info "time msg received: " msg)
   (swap! time-state assoc :time msg)
   nil))

(defn time-ui []
  [:div.rows
   [:p.text-xl.text-blue-700 "This demo shows how to push data from the server."]
   [:p.text-xl.text-blue-700 "time is pushed every 10 seconds."]
   [:div (pr-str (:time @time-state))]])

(defn time-page [{:keys [route-params query-params handler] :as route}]
  [:div
   [:div.text-green-300 "time ui"]
   [time-ui]])

; (add-page time-page :user/time)

(add-page-site time-page :user/time)