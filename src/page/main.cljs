(ns page.main
  (:require
   [webly.spa.env :refer [get-mode get-resource-path]]
   [lib.ui :refer [wrap-page-site link-dispatch]]))

; main page 

(defn main-page  [_route-data]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "demo"]
   [:p "This website shows what you can do with webly/goldly."]
   [:p "all pages are rendered via sci interpreted clojurescript."]
   (let [mode (get-mode)
         rp (get-resource-path)]
     (when (not (= mode :dynamic))
       [:div.bg-red-500 
         [:p "not running in dynamic mode. clj-services will not work!"]
         [:p "resource path: " (pr-str rp)]]))])

(def main-page-wrapped (wrap-page-site main-page))