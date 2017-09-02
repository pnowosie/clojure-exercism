(ns all-your-base)

(defn to-base [base n]
(loop [n n digits nil]
    (if (zero? n)
        (or digits '(0))
        (recur (quot n base) (cons (rem n base) digits)))))

(defn convert [base digits dest]
(let [valid-digits (set (range base))]
    (if-not (and (every? valid-digits digits)
                 (<= 2 (min base dest))
                 (seq digits))
        nil
        (to-base dest 
            (reduce #(+ %2 (* %1 base)) 0 digits)))
))