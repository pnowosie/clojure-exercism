(ns strain)

(defn retain [pred coll]
    (reduce (fn [acc elt] (if (pred elt) (conj acc elt) acc)) [] coll))

(defn discard [pred coll]
    (retain (complement pred) coll))