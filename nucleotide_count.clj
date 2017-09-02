(ns nucleotide-count)

(defn validate [symbol]
    (or (#{ \A \C \G \T } symbol) (assert nil)))

(defn nucleotide-counts [dna]
    (into {\A 0, \T 0, \C 0, \G 0}
          (frequencies dna)))

(defn count [symbol dna]
    ((nucleotide-counts dna) (validate symbol)))
