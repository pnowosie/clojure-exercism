(ns allergies)

(def items {
    :eggs           1
    :peanuts        2
    :shellfish      4
    :strawberries   8
    :tomatoes      16
    :chocolate     32
    :pollen        64
    :cats         128
})

(defn allergic-to? [n i]
    (-> i items (bit-and n) pos?))

(defn allergies [n]
    (->> (keys items)
         (filter #(allergic-to? n %))))