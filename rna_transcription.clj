(ns rna-transcription)

(defn to-rna [dna]
  (apply str
    (map
      #(or ({ \C \G \G \C \A \U \T \A } %) (assert nil))
      dna
    )
  )
)

