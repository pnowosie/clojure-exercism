(ns wordy)

(def num-pat  "(-?\\d+)")
(def oper-pat "(plus|minus|multiplied|divided)(?: by)?")
(def pattern  (re-pattern
 (str "^What is " num-pat " " oper-pat " " num-pat
      "(?: " oper-pat " " num-pat ")?"      ;; optional 2nd operator with number
      "\\?$"                                ;; trailing '?'
 )))

(defn tokenize [sentence]
    (or (re-find pattern sentence) 
        (IllegalArgumentException.)))

(defn parse-num [token]
    (Integer/parseInt token))

(defn parse-oper [token]
    (condp = token
        "plus"       +
        "minus"      -
        "multiplied" *
        "divided"    /))

(defn parse-expr [tokens]
    (map #(%1 %2) (cycle [parse-num parse-oper]) (remove nil? (rest tokens))))

(defn eval-expr 
([n1 o1 n2] (o1 n1 n2))
([n1 o1 n2 o2 n3] (o2 (o1 n1 n2) n3)))

(defn evaluate [sentence]
    (->> sentence
        tokenize
        parse-expr
        (apply eval-expr)
    ))
