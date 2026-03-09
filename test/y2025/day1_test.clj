(ns y2025.day1-test
  (:require [y2025.day1 :as sut]
            [clojure.test :refer :all]))

(deftest turn-dial-test
  (is (= (sut/turn-dial 98 1) 99))
  (is (= (sut/turn-dial 99 1) 0))
  (is (= (sut/turn-dial 50 70) 20)))

(deftest parse-number-test
  (is (= (sut/as-int "L50") -50)))
