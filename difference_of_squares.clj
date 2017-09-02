(ns difference-of-squares)

(defn sq [n]
    (* n n))

(defn sum-of-squares [n]
    (apply + (map sq (range (inc n)))))

(defn square-of-sums [n]
    (sq (apply + (range (inc n)))))

(defn difference [n]
    (- (square-of-sums n) (sum-of-squares n)))