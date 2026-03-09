(ns y2025.common
  (:require
   [clojure.string :as s]))

(defn exec [solution file]
  (let [content (slurp file)
        lines (s/split-lines content)]
    (solution lines)))
