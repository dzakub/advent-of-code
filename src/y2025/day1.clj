(ns y2025.day1
  (:require
   [clojure.string :as s]
   [y2025.common :refer [exec]]
   [clojure.math :as math]))

(defn as-int [x]
  (let [int-string (-> x
                       (s/replace "R" "")
                       (s/replace "L" "-"))]
    (Integer/parseInt int-string)))

(defn turn-dial [start rotation]
  (mod (+ start rotation) 100))

(defn first-problem [rotations]
  (loop [r (map as-int rotations)
         prev 50
         count-zeros 0]
    (if (empty? r)
      count-zeros
      (let [code (turn-dial prev (first r))]
        (recur (rest r) code (case code
                               0 (inc count-zeros)
                               count-zeros))))))

(defn second-problem [rotations]
  ;; (println "next run")
  (loop [r (map as-int rotations)
         prev-code 50
         count-zeros 0]
    (if (empty? r)
      count-zeros
      (let [rotation (first r)
            next-code (turn-dial prev-code rotation)
            zeros-in-rotation (if (> rotation 0)
                                (math/floor-div (+ prev-code rotation) 100)
                                (if (>= (abs rotation) prev-code)
                                  (if (not= 0 prev-code)
                                    (inc (math/floor-div (abs (+ prev-code rotation)) 100))
                                    (math/floor-div (abs (+ prev-code rotation)) 100))
                                  0))]
        ;;(println rotation "::" prev-code "->" next-code "=" zeros-in-rotation)
        (recur (rest r) next-code (+ count-zeros zeros-in-rotation))))))

(comment
  (exec first-problem "src/y2025/day1.in")
  (exec second-problem "src/y2025/day1.in")
  (second-problem ["L68"
                  "L30"
                  "R48"
                  "L5"
                  "R60"
                  "L55"
                  "L1"
                  "L99"
                  "R14"
                  "L82"])
  (as-int "R34")
  (turn-dial 30 70)
  (turn-dial 99 2)
  (turn-dial 99 1)
  (turn-dial 2 3))

