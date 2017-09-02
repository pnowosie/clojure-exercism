(ns binary-search)

(defn middle [v]
    (quot (count v) 2))

(defn search-for [e v]
  (if (vector? v)
    (if (empty? v)
      (throw (Exception. "Element not found."))
      (let [m (middle v)
            u (nth v m)]
        (case (compare e u)
            0 m
            1 (+ 1 m (search-for e (subvec v (inc m))))
           -1 (search-for e (subvec v 0 m))))
    )
    (search-for e (into [] v))
))