(ns hamming)

(defn distance [dna1 dna2]
    (or 
        (and (= (count dna1) (count dna2))
             (->> (map = dna1 dna2)
                  (filter not)
                  (count)
             ))
        nil)
)