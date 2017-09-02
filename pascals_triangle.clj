(ns pascals-triangle)

(defn succ [row]
    (concat [1] (map +' row (rest row)) [1]))

(def triangle
    (iterate succ [1]))

(defn row [n]
    (-> triangle (nth (dec n))))