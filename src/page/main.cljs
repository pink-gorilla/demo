
; main page 

(defn main-page  [{:keys [handler route-params query-params] :as route}]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "demo user app"]
   [link-href "/devtools/help" "goldly developer tools"]

   [:div.bg.green-300

    [link-href "/about" "goldly about"]]

   [link-href "/time" "time - server push demo"]
   [link-href "/fortune" "fortune cookies - request/response demo"]

   [link-href "/vega" "vega"]
   [link-href "/bmi" "bmi"]
   [link-href "/iss" "iss leaflet"]
   [link-href "/aggrid" "aggrid"]])

; (add-page main-page :user/main)

(add-page-template main-page :user/main)
