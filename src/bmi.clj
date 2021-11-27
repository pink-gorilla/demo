(ns bmi
  (:require [goldly.service.core :as s]))

(defn calc-bmi-server [bmi-data]
  (println "calc-bmi-server: " bmi-data)
  (let [{:keys [height weight bmi] :as data} bmi-data
        h (/ height 100)]
    (if (nil? bmi)
      (assoc data :bmi (int (/ weight (* h h))))
      (assoc data :weight (int (* bmi h h))))))

(s/add {:bmi/calc calc-bmi-server})

(comment

  (calc-bmi-server {:height 205 :weight 90.1})

;
  )