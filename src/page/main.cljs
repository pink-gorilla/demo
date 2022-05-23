(ns page.main
  (:require
   [lib.ui :refer [add-page-site link-dispatch]]))

; main page 

(defn main-page  [{:keys [handler route-params query-params] :as route}]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "demo-goldly"]
   [:p "This website shows what you can do with goldly."]

   [:p "Users normally would not get developer tooling:"]
   [link-dispatch [:bidi/goto :devtools] "goldly developer tools"]])


(add-page-site main-page :user/main)
