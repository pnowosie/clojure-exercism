(ns anagram)

(defn anagram? [s1 s2]
  (let [l1 (clojure.string/lower-case s1)
        l2 (clojure.string/lower-case s2)]
  (and (= (sort l1) (sort l2))
       (not= l1 l2)))
)

(defn anagrams-for [str coll]
  (filter #(anagram? str %) coll)
)