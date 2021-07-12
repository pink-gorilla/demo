(def data
  (map (fn [i] {:idx i
                :name "jon"
                :date (t/now)
                :text "jg kj jkhj jh gk g"})
       (range 500)))

(defmethod reagent-page :user/aggrid [{:keys [route-params query-params handler] :as route}]
  [:div.h-screen.w-screen
   [:div {:style {:position "absolute"}}
    [link/href "/" "main"]]
   ;[:p "data" (pr-str data)]
   [aggrid {:data data
            :box :fl
            :pagination true
            :paginationAutoPageSize true}]])
