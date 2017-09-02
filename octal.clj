(ns octal)

(defn to-decimal [bin]
    (if (every? #{\0 \1 \2 \3 \4 \5 \6 \7} bin)
        (reduce #(+ (* 8 %1) (- (int %2) 48)) 0 bin)
        0))