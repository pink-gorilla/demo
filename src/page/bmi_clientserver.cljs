(ns page.bmi-clientserver
  (:require
   [reagent.core :as r]
   [goldly.service :as service]
   [user :refer [evt-val]]
   [lib.ui :refer [add-page-site link-dispatch]]))

(def bmi-data (r/atom {:height 180 :weight 80}))

(defn calc-bmi-server []
  (.log js/console "calculating: " @bmi-data)
  (service/run-a bmi-data [:cookie] :bmi/calc @bmi-data))

(defn slider [param value min max]
  [:input {:type "range" :value value :min min :max max
           :style {:width "100%"}
           :on-change (fn [e]
                        (swap! bmi-data assoc param (js/parseInt (.. e -target -value)))
                        (when (not= param :bmi)
                          (swap! bmi-data assoc :bmi nil)))}])

(defn bmi-component []
  (let [{:keys [weight height bmi]} (calc-bmi-server)
        [color diagnose] (cond
                           (< bmi 18.5) ["orange" "underweight"]
                           (< bmi 25) ["inherit" "normal"]
                           (< bmi 30) ["orange" "overweight"]
                           :else ["red" "obese"])]
    [:div
     [:h3 "BMI calculator"]
     [:div
      "Height: " (int height) "cm"
      [slider :height height 100 220]]
     [:div
      "Weight: " (int weight) "kg"
      [slider :weight weight 30 150]]
     [:div
      "BMI: " (int bmi) " "
      [:span {:style {:color color}} diagnose]
      [slider :bmi bmi 10 50]]]))

(defn bmi-server-page  [_route-data]
  [:div
   [link-dispatch [:bidi/goto :user/main] "main"]
   [:div
    [:p (str  "height: " (:height @bmi-data))]
    [slider :height (:height @bmi-data) 10 220] ; babies are perhaps only 10cm, adults can go up to 220.
    ]

   [:div.text-green-300 "bodymass index"]
   [bmi-component]])

(add-page-site bmi-server-page :user/bmi-server)
