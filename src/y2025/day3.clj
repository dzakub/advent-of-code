(ns y2025.day3
  (:require [y2025.common :refer [exec]]))

(defn max-joltage2 [size line]
  (loop [bateries (map #(parse-long (str %)) (seq line))
         digit 0
         depth size]
    (if (= depth 0)
      digit
      (let [max-digit (reduce max (drop-last (dec depth) bateries))]
        (recur (rest (drop-while #(not= % max-digit) bateries)) (+ (* 10 digit) max-digit) (dec depth))))))

(def max-joltage-task1 (partial max-joltage2 2))
(def max-joltage-task2 (partial max-joltage2 12))

(defn solution [lines]
  (->> lines
       (map max-joltage-task1)
       (reduce +)))

(defn solution2 [lines]
  (->> lines
       (map max-joltage-task2)
       (reduce +)))

(comment
  (exec solution "src/y2025/day3.in")
  (exec solution2 "src/y2025/day3.in")
  (max-joltage2 12 "987654321111111")
  (max-joltage2 12 "234234234234278")
  )
