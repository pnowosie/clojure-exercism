(ns luhn
    (:require [clojure.string :as str]))

(defn strip-spaces [s]
    (str/replace s #"\s+" ""))

(defn all-digits? [s]
    (not (re-find #"[^0-9]" s)))

(defn luhn-sum [s] 
    (let [ds (reverse (map #(- (int %) (int \0)) s))]
        (->> ds
            (map * (cycle [1 2]))
            (map #(if (< 9 %) (- % 9) %))
            (reduce +))))

(def luhn-valid? 
    (comp zero? #(mod % 10) luhn-sum))

(defn valid? [s]
    (let [s (strip-spaces s)]
        (and 
            (< 1 (count s))
            (all-digits? s)
            (luhn-valid? s)
)))