(ns lib.ui
  (:require
   [re-frame.core :as rf]
   [ui.site.template]
   [ui.site.layout]))

;; links

(defn link-fn [fun text]
  [:a.bg-blue-600.cursor-pointer.hover:bg-red-700.m-1
   {:on-click fun} text])

(defn link-dispatch [rf-evt text]
  (link-fn #(rf/dispatch rf-evt) text))

(defn link-href [href text]
  [:a.bg-blue-600.cursor-pointer.hover:bg-red-700.m-1
   {:href href} text])

;; site layout

(defn site-header []
  [ui.site.template/header-menu
   {:brand "Demo"
    :brand-link "/"
    :items [{:text "fortune-cookie" :dispatch [:bidi/goto 'page.fortune/fortune-page-wrapped :query-params {}]}
            {:text "bodymass-indicator"  :dispatch [:bidi/goto 'page.bmi/bmi-page-wrapped]}
            {:text "time"  :dispatch [:bidi/goto 'page.time/time-page-wrapped]}
            {:text "space-station"  :dispatch  [:bidi/goto 'page.leaflet-iss/iss-page-wrapped]}
            {:text "jon-grid"  :dispatch [:bidi/goto 'page.aggrid/aggrid-page-wrapped]}
            {:text "vega"  :dispatch [:bidi/goto 'page.vega/vega-page-wrapped]}
           ; {:text "feedback" :link "https://github.com/pink-gorilla/goldly/issues" :special? true}
            ]}])

(defn wrap-page-site [fn-page]
  (fn [route]
    [ui.site.layout/header-main  ; .w-screen.h-screen
     [site-header]
     [fn-page route]]))



