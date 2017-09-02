(ns perfect-numbers)

(defn classify' [n sum]
  (let [dif (- sum n)]
    (cond
      (pos? dif) :abundant
      (neg? dif) :deficient
      :else :perfect)))

(defn factors [n]
    (let [ds (range 1 n)]
    (filter #(zero? (mod n %)) ds)
  ))

(defn classify [n]
    (if (neg? n)
        (throw (IllegalArgumentException.))
        (classify' n (reduce + (factors n)))))