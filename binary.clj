(ns binary)

(defn to-decimal [bin]
    (if (every? #{\0 \1} bin)
        (reduce #(+ (* 2 %1) (- (int %2) 48)) 0 bin)
        0))