(ns triangle
    (:refer-clojure :exclude [type]))

(defn type [a b c]
(let [[a b c] (sort [a b c])
      sides (count (set [a b c]))]
    (cond
        (>= c (+ a b)) :illogical
        (= 1 sides) :equilateral
        (= 2 sides) :isosceles
        :else :scalene)))