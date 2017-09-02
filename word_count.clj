(ns word-count
  (:require [clojure.string :as str]))

(defn normalize [word]
  (str/replace (str/lower-case word) #"[^a-z0-9]" "")
)

(defn text->list [sentence]
  (filter #(not= "" %)
    (map normalize (str/split sentence #"\s")))
)

(defn inc-word [word wc]
  { word (inc wc) }
)

(defn word-count [sentence]
  (reduce #(conj %1 (inc-word %2 (get %1 %2 0)))
          {}
          (text->list sentence)
  )
)
