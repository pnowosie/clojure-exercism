(ns largest-series-product)

(defn largest-product [k s]
(when (or (> k (count s)) (neg? k))
    (throw (Exception. "Length has to be positive integer.")))
(when (re-seq #"[^\d]" s)
    (throw (Exception. "String must contain only digits.")))
(loop [ns (map #(- (int %) 48) s) maxp 0]
    (cond 
        (zero? k) 1
        (or (empty? ns) (< (count ns) k)) maxp
        :else (recur (rest ns) (max maxp (apply * (take k ns))))
)))