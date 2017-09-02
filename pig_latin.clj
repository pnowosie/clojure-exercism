(ns pig-latin
    (:require [clojure.string :as s]))

(defn translate-word [s]
    (let [f   (first s)
          fs  (subs s 0 2)
          fst (subs s 0 3)]
        (case fst
            ("sch" "squ" "thr") (str (subs s 3) fst "ay")
        (case fs
            ("xr" "yt") (str s "ay")
            ("ch" "qu" "th") (str (subs s 2) fs "ay")
        (case f
            (\f \k \p \q \r \x \y) (str (subs s 1) f "ay")
            (str s "ay"))))))

(defn translate [s]
    (s/join " " (map translate-word (s/split s #" "))))