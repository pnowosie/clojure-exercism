(ns leap)

(def div? (comp zero? mod))
(def not-div? (comp not div?))

(defn leap-year? [yr]
    (and (div? yr 4)
         (or (not-div? yr 100)
             (div?     yr 400)))
)