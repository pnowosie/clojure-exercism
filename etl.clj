(ns etl)

(defn transform [old]
  (reduce (fn [ini [k v]]
            (into ini
                  (map #(vector (clojure.string/lower-case %) k) v)))
           {}
           old)
)
