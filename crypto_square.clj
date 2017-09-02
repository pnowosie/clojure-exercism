(ns crypto-square
    (:require [clojure.string :as str]))

(defn normalize-plaintext [s]
    (str/replace (str/lower-case s) #"[^a-z0-9]" ""))

(defn square-size [s]
    (-> s count Math/sqrt Math/ceil int))

(defn plaintext-segments [s]
(let [msg (normalize-plaintext s)
      size (square-size msg)]
    (->> (partition-all size size msg)
         (map str/join))))

(defn normalize-ciphertext [s]
(let [msg (normalize-plaintext s)
        size (square-size msg)]
    (->> (for [x (range size)] 
                (take-nth size (drop x msg)))
            (map str/join)
            (str/join " "))))

(defn ciphertext [msg]
    (str/replace (normalize-ciphertext msg) #"\s" ""))