(ns grade-school)

(defn grade [db n]
  (get db n []))

(defn add [db name n]
  (assoc db n
    (conj (grade db n) name)))

(defn sorted [db]
  (into (sorted-map)
        (map #(let [[n names] %]
                   [ n (sort names)])
            db)))
