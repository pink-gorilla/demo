
; main page 

(defn main-page  [{:keys [handler route-params query-params] :as route}]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "demo-goldly"]
   [:p "This website shows what you can do with goldly."]

   [:p "Users normally would not get developer tooling:"]
   [link-href "/devtools/help" "goldly developer tools"]])

; (add-page main-page :user/main)

(add-page-site main-page :user/main)
