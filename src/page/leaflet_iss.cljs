(ns page.leaflet-iss
  (:require
   [reagent.core :as r]
   [ui.leaflet :refer [leaflet-map]]
   [pinkgorilla.repl.cljs.http :refer [get-json]]
   [lib.ui :refer [wrap-page-site]]))

; ISS Location tracker - realtime

(def issstate
  (r/atom
   {:first true
    :data "not yet downloaded"}))

(defn pos [] ;{ :iss_position {:longitude "-111.4007", :latitude "2.9204"}}
  (when-let [lng (get-in @issstate [:data :iss_position :longitude])]
    (when-let [lat (get-in @issstate [:data :iss_position :latitude])]
      [(js/parseFloat lat) (js/parseFloat lng)])))


;(def url  "http://api.open-notify.org/iss-now.json")

; we use google translate as an ssh proxy. 
; this is needed because demo when served on github pages runs on https, and the iss-now api is only on http.

(def url "https://api-open--notify-org.translate.goog/iss-now.json?_x_tr_sch=http&_x_tr_sl=ja&_x_tr_tl=en&_x_tr_hl=es-419")

(defn download []
  ;; http://open-notify.org/Open-Notify-API/ISS-Location-Now/
  (get-json url issstate [:data]))

(defn iss []
  (when (:first @issstate)
    (swap! issstate assoc :first false)
    (download)
    (js/setInterval download 30000)
    nil)
  (if-let [p (pos)]
    [:<>
     [:div {:style {:position "fixed"
                    :z-index 9999
                    :top "200px"
                    :left "20px"
                    :width "200px";
                    :height "100px"
                    :border "3px solid #73AD21"}
            :class "bg-blue-300"}
      "current iss location "
      (pr-str p)]
     [:div.w-full.h-full.bg-red-100
      [leaflet-map {:box :fl
                    :center p
                    :zoom 4
                    :features [{:type :marker
                                :position p
                                :popup "the international space station is here!"}]}]]]
    [:div.w-full.h-full
     [:p "loading iss position.."]]))

(defn iss-page [_route-data]
  [iss])

(def iss-page-wrapped (wrap-page-site iss-page))


