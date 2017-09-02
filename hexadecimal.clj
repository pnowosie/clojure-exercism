(ns hexadecimal)

(defn hex-to-int [hex]
(let [digits   "0123456789abcdef"
      hex->dec (reduce #(assoc %1 %2 (.indexOf digits (str %2))) {} digits)]
    (if (every? hex->dec hex)
        (reduce #(+ (* 16 %1) (hex->dec %2)) 0 hex)
        0)))