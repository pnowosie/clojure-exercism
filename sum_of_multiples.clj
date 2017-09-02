(ns sum-of-multiples)

(defn is-multi-of [n ds]
    (some #(zero? (mod n %)) ds))

(defn sum-of-multiples [ds N]
    (->> (range N)
        (filter #(is-multi-of % ds))
        (apply +)))