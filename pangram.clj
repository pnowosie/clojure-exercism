(ns pangram
    (:require [clojure.string :as s]))

(def a-z
    (->> (range (int \a) (inc (int \z)))
         (map char)))

(defn pangram? [s]
    (let [freq (frequencies (s/lower-case s))]
        (->> a-z
            (map #(get freq % 0))
            (every? (partial < 0)))))