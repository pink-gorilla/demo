;;; # Shapes (from maria cloud)

(ns mariacloud.shapes.dem
  (:require
   [awb99.shapes.core :as s :refer [color-names square layer colorize]]))

(s/circle 20)

{:square (s/square 25) :circle (s/circle 15)}

(doc s/circle)

(s/rectangle 100 50)

(map #(+ 7 %) (range 5))

(vec (map #(s/circle (+ 10 %)) (range 50)))
(vec (range 5))

s/color-names

(s/colors-named "yellow")

(s/layer
 (s/colorize "aqua" (s/square 50))
 (s/colorize "magenta" (s/circle 25)))

(s/layer
 (s/colorize "springgreen" (s/circle 25))
 (s/position 50 25 (s/colorize "pink" (s/circle 25))))

(s/layer
 (s/colorize "aqua" (s/circle 40))
 (s/position 10 10 (s/colorize "magenta" (s/triangle 24)))
 (s/position 45 10 (s/colorize "magenta" (s/triangle 24)))
 (s/position 40 55 (s/colorize "white" (s/circle 10))))

(map s/square [2 4 8 16 32 64 128])

(map (fn [color] (s/colorize color (s/circle 25)))
     ["red" "blue" "green"])

(map (fn [o] (s/opacity o (s/square 40)))
     [0, 1/4, 1/2, 3/4, 1])

;; @@ [cljs]
(let [t (s/triangle 100)] ;; <-- this vector holds our name/value pair
  ;; now we write an expression using that name:
  (s/layer t
           (s/position 50 0 t)
           (s/position 88 0 t)
           (s/position 113 0 t)
           (s/position 185 0 t)
           (s/position 195 0 t)
           (s/position 238 0 t)))

(def rainbow
  ["red" "orange" "yellow" "green" "blue" "indigo" "violet"])

(map (fn [c] (s/colorize c (s/circle 25))) rainbow)

(def colorized-circle
  (fn [c] (s/colorize c (s/circle 25))))

(colorized-circle "slategray")

(map (fn [c] (s/colorize c (s/rectangle 300 20)))
     rainbow)

;; @@ [cljs]
(defn vertical-flag [colors]
  (apply s/above
         (map (fn [c]
                (s/colorize c (s/rectangle 300 (/ 200 (count colors)))))
              colors)))

; germany
(vertical-flag ["black" "red" "gold"])

; indonesia
(vertical-flag ["red" "white"])

; catalonia
(vertical-flag ["gold" "red" "gold" "red" "gold" "red" "gold" "red" "gold"])

[(s/circle 25) nil]

