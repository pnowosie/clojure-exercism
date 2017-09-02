(ns bob
  (:require [clojure.string :as string]))

(defn yelling? [phrase]
  (and
    (some #(Character/isLetter %) phrase)
    (every?
      #(or (not (Character/isLetter %)) (Character/isUpperCase %))
      phrase)
  ))

(defn question? [phrase]
  (string/ends-with? phrase "?"))

(defn address? [phrase]
  (string/blank? phrase))

(defn response-for [phrase]
  (cond
    (address? phrase) "Fine. Be that way!"
    (yelling? phrase) "Whoa, chill out!"
    (question? phrase) "Sure."
    :else "Whatever.")
)

