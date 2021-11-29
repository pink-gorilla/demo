


;; site layout

(defn site-header []
  [site/header-menu
   {:brand "DemoGoldly"
    :brand-link "/"
    :items [{:text "fortune-cookie" :dispatch [:bidi/goto :user/fortune :query-params {}]}
            {:text "bodymass-indicator"  :dispatch [:bidi/goto :user/bmi]}
            {:text "time"  :dispatch [:bidi/goto :user/time]}
            {:text "space-station"  :dispatch  [:bidi/goto :user/iss]}
            {:text "jon-grid"  :dispatch [:bidi/goto  :user/aggrid]}
            {:text "vega"  :dispatch [:bidi/goto :user/vega]}
           ; {:text "feedback" :link "https://github.com/pink-gorilla/goldly/issues" :special? true}
            ]}])

(defn add-page-site [page name]
  (let [wrapped-page (fn [route]
                       [layout/header-main  ; .w-screen.h-screen
                        [site-header]
                        [page route]])]
    (add-page wrapped-page name)))



