(ns prime-factors)

(defn of [n] 
(loop [n n p 2 q (Math/sqrt n) ds []]
  (cond (< n p) ds
        (< q p) (conj ds n)
        (zero? (mod n p))
            (recur (quot n p) p (Math/sqrt (quot n p)) (conj ds p))
        :else
            (recur n (inc p) q ds))))