(ns grains)

(defn square [n]
  (->> (repeat (dec n) 2)
       (reduce *')))

(defn total 
([] (total 64))
([n] (dec (square (inc n))  
;; next square contains 2 times more that the sum of all previous (- 1)
)))