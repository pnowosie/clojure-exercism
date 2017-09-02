(ns accumulate)

(defn accumulate [f coll]
    (loop [C coll m []]
        (if (seq C)
            (recur (rest C) (conj m (f (first C))))
            m)))