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

;; http://open-notify.org/Open-Notify-API/ISS-Location-Now/
; (def url  "http://api.open-notify.org/iss-now.json")

#_ {"timestamp" 1713834614
    "iss_position" {"longitude" "31.4551"
                 "latitude" "33.6290"}
    "message" "success"}

#_(defn pos [] ;{ :iss_position {:longitude "-111.4007", :latitude "2.9204"}}
  (when-let [lng (get-in @issstate [:data :iss_position :longitude])]
    (when-let [lat (get-in @issstate [:data :iss_position :latitude])]
      [(js/parseFloat lat) (js/parseFloat lng)])))


; we use google translate as an ssh proxy. 
; this is needed because demo when served on github pages runs on https, and the iss-now api is only on http.

;(def url "https://api-open--notify-org.translate.goog/iss-now.json?_x_tr_sch=http&_x_tr_sl=ja&_x_tr_tl=en&_x_tr_hl=es-419")

(def url "https://api.wheretheiss.at/v1/satellites/25544")

#_{"name" "iss"
 "id" 25544
 "latitude" 32.849420902899
 "longitude" 30.295992877302
 "altitude" 414.81381786305
 "velocity" 27603.64815935
 "visibility" "eclipsed"
 "footprint" 4480.9838165584
 "timestamp" 1713834594
 "daynum" 2460423.5485417
 "solar_lat" 12.643240818375
 "solar_lon" 162.10532634786
 "units" "kilometers"}

(defn pos [] 
  (when-let [lng (get-in @issstate [:data :longitude])]
    (when-let [lat (get-in @issstate [:data :latitude])]
      [lat lng])))

(defn download []
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


