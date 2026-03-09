(ns y2025.day2
  (:require
   [clojure.math :as math]
   [clojure.string :as s]))

(defn read-input []
  (let [content (slurp "src/y2025/day2.in")
        ranges (s/split content #",")]
    (print ranges)
    (map #(s/split % #"-") ranges)))

(defn invalid1? [x]
  (let [s (str x)
        parts (split-at (math/floor-div (count s) 2) s)]
    (= (first parts) (second parts))))

(defn find-invalid-ids [invalid? [start end]]
  (let [s (parse-long start)
        e (parse-long end)]
    (->> (range s (inc e))
         (filter invalid?))))

(defn solution [invalid?]
  (reduce + (flatten
             (->> (read-input)
                  (map #(find-invalid-ids invalid? %))))))

(def solution1 (partial solution invalid1?))

(defn invalid2? [x]
  (loop [id (drop 1 (str x))
         digits (into [] (take 1 (str x)))
         result false]
    (if (empty? id)
      result
      (let [digits-size (count digits)
            new-result (= digits (take (count digits) id))
            new-id (if new-result (drop digits-size id) (drop 1 id))
            new-digits (if new-result digits (conj digits (first id)))]
        (println new-result new-id new-digits)
        (recur new-id new-digits new-result)))))

(defn invalid3? [x]
  (let [s (str x)
        half-size (/ (count s) 2)
        padding (repeat half-size "a")
        resuls (->> (range 1 (inc half-size))
                    (map #(partition % % padding s))
                    (filter #(> (count %) 1))
                    (map #(apply = %)))]
    (some true? resuls)))

(def solution2 (partial solution invalid3?))

(comment
  (solution2)
  (solution1)
  (read-input)
  (invalid1? 11)
  (find-invalid-ids invalid2? ["11" "22"])
  (find-invalid-ids invalid3? ["1188511880" "1188511890"])
  (find-invalid-ids invalid2? ["95" "1012"]))
