(ns roman-numerals)

(def roman-numbers {
      1000 "M" 900 "CM" 500 "D" 400 "CD"
       100 "C"  90 "XC"  50 "L"  40 "XL"
        10 "X"   9 "IX"   5 "V"   4 "IV" 1 "I" })

(defn numerals [n]
(loop [n n 
       adds (reverse (sort (keys roman-numbers))) 
       rn []]
    (let [a (some #(and (<= % n) %) adds)
          k (when a (quot n a))
          r (when k (rem n a))]
        (if k 
            (recur r (remove #(> % r) adds) (into rn (repeat k (roman-numbers a))))
            (apply str rn))
    )))