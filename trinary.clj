(ns trinary)

(defn to-decimal [bin]
    (if (every? #{\0 \1 \2} bin)
        (reduce #(+ (* 3 %1) (- (int %2) 48)) 0 bin)
        0))