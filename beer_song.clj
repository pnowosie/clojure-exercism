(ns beer-song
    (:require  [clojure.string :as str]))

(defn bottles [n]
    (str (if (zero? n) "no more" n) " bottle" (when (not= 1 n) "s") " of beer")
)

(defn first-line [n]
    (str (str/capitalize (bottles n)) " on the wall, " (bottles n) ".\n")
)

(defn second-line [n]
    (if (neg? n)
        "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
        (str "Take " (if (zero? n) "it" "one") " down and pass it around, " (bottles n) " on the wall.\n"))
)

(defn verse [n]
    (str (first-line n) (second-line (dec n)))
)

(defn sing 
    ([n] (sing n 0))
    ([n k]
        (->> (range n (dec k) -1)
            (map verse)
            (str/join "\n"))
))
