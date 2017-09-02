(ns acronym
    (:require [clojure.string :as s]))

;; process each char from a string, accumulator is a pair whos first elt
;; is list of acronim chars and second is mode which effect on next chars
(defn process-char [[acr m] char]
    (let [spaces #{ \space \- }]
        (cond 
            (and (Character/isUpperCase char)
                (not= :ignore m))           [(conj acr char) :ignore]
            (and (Character/isUpperCase char)
                (= :ignore m))              [acr :ignore]
            (and (Character/isLetter char)
                 (= :upper m))              [(conj acr (s/upper-case char)) :ignore]
            (spaces char)                   [acr :upper]
            :else                           [acr :pass])))

(defn acronym [s]
    (->> s
        (reduce process-char [[] :pass])
        first
        (apply str)))