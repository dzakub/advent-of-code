(ns y2025.day3
  (:require [y2025.common :refer [exec]]))

(defn max-joltage [line]
  (let [bateries (map #(parse-long (str %)) (seq line))
        first-digit (reduce max (butlast bateries))
        remaing-battery (rest (drop-while #(not= % first-digit) bateries))
        second-digit (reduce max remaing-battery)]
    (+ (* 10 first-digit) second-digit)))

(defn solution [lines]
  (->> lines
       (map max-joltage)
       (reduce +)))

(comment
  (exec solution "src/y2025/day3.in")
  (max-joltage "987654321111111")
  (max-joltage "234234234234278")
  (max-joltage "818181911112111")
  (max-joltage "811111111111119"))
