(ns page.bmi
  (:require
   [reagent.core :as r]
   [lib.ui :refer [wrap-page-site]]))

; define the calculation function. Note that 
; 1. a change in the atom will trigger re-rendering
; 2. setting :bmi to nil will calculate bmi; otherwise the weight will be adjusted. 

(def bmi-state (r/atom {:height 180
                        :weight 80}))

(defn calc-bmi []
  (let [{:keys [height weight bmi] :as data} @bmi-state
        h (/ height 100)]
    (if (nil? bmi)
      (assoc data :bmi (/ weight (* h h)))
      (assoc data :weight (* bmi h h)))))

; the slider is used for all 3 elements.
; however, the non-bmi sliders will reset :bmi property!
(defn slider [param value min max]
  [:input {:type "range" :value value :min min :max max
           :style {:width "100%"}
           :on-change (fn [e]
                        (swap! bmi-state assoc param (.. e -target -value))
                        (when (not= param :bmi)
                          (swap! bmi-state assoc :bmi nil)))}])

(defn bmi-ui []
  (let [{:keys [weight height bmi]} (calc-bmi)
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

; lets change the height manually (the slider above adjusts)
; (swap! bmi-data assoc :height 150)
;(swap! bmi-data assoc :height 180)

(defn bmi-page [{:keys [_route-params _query-params _handler] :as _route}]
  [:div
   [:div.text-green-300 "bodymass index"]
   [bmi-ui]])

(def bmi-page-wrapped (wrap-page-site bmi-page))