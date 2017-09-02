(ns sublist)

(defn sublist? [l r]
(loop [l l r r len (count l)]
    (and (<= len (count r))
         (or (= l (take len r))
             (recur l (rest r) len)))
))

(defn classify [l r]
(let [l-in-r (sublist? l r)
      r-in-l (sublist? r l)]
    (cond
        (and l-in-r r-in-l) 
               :equal
        l-in-r :sublist
        r-in-l :superlist
        :else  :unequal
    )
))