(ns atbash-cipher
    (:require [clojure.string :as str]))

(defn atbash [c]
    (if (apply <= (map int [\a c \z]))
        (char (+ (int \z) (- (int \a) (int c))))
        c))

(defn normalize [s]
    (str/replace 
        (str/lower-case s) #"[^a-z0-9]" ""))

(defn encode [s]
    (->> s
        normalize
        (map atbash)
        (partition-all 5)
        (map #(apply str %))
        (str/join " ")))