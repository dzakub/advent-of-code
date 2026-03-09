(ns y2025.day2-test
  (:require
   [clojure.test :refer :all]
   [y2025.day2 :as sut]))

(deftest invalid2?-test
  (is (not (sut/invalid3? 1)))
  (is (not (sut/invalid3? 12)))
  (is (not (sut/invalid3? 12123)))
  (is (sut/invalid3? 11))
  (is (sut/invalid3? 1212))
  (is (sut/invalid3? 123123))
  (is (sut/invalid3? 121212))
  (is (sut/invalid3? 1188511885)))

(deftest y2025.day2-test
  (is (= 1 1)))
