(ns kindergarten-garden
    (:use [clojure.string :only (lower-case split)]))

(def names [ "alice" "bob" "charlie" "david" "eve" "fred" "ginny" "harriet" "ileana" "joseph" "kincaid" "larry" ])
(def plants { \C :clover, \G :grass, \R :radishes, \V :violets })

(defn parse-garden [garden]
    (let [[fst snd] (map #(partition 2 %) (split garden #"\n"))]
        (map concat fst snd)))

(defn garden
([s] (garden s names))
([s n] (zipmap 
            (map (comp keyword lower-case) (sort n))
            (map #(map plants %) (parse-garden s)))))