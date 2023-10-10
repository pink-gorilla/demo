(ns page.main
  (:require
   [lib.ui :refer [wrap-page-site link-dispatch]]))

; main page 

(defn main-page  [_route-data]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "demo-goldly"]
   [:p "This website shows what you can do with goldly."]

   [:p "Users normally would not get developer tooling:"]
   [link-dispatch [:bidi/goto 'goldly.devtools.page.help/devtools-page] "goldly developer tools"]])

(def main-page-wrapped (wrap-page-site main-page))