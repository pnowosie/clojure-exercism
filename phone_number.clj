(ns phone-number
    (:require [clojure.string :as str]))

(defn number [s]
    (let [n (str/replace s #"[^\d]" "")]
        (condp = (count n) 
            10 n
            11 (if (= \1 (first n))
                    (subs n 1)
                    "0000000000")
            "0000000000")
            ))

(defn area-code [n]
    (subs (number n) 0 3))

(defn pretty-print [s]
    (let [n (number s)
          [_ f m l] (re-find #"(\d{3})(\d{3})(\d+)" n)]
    (format "(%s) %s-%s" f m l)))