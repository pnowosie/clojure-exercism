(ns bracket-push)

(def matching {
       \) \( 
       \] \[
       \} \{ 
})

(def openinig?
    (set (vals matching)))

;; acc contains opening brackets while processing a string
;; if next is closing bracket it must much to the lastly added opening one
;; if so opening (matched) bracket is removed from acc
;; if not keyword which never can be match is put into acc, so it never can be emptied
(defn balance [acc b]
    (let [last-open  (first acc)
          match-open (matching b)]
    (cond
      (openinig? b) (cons b acc)
      match-open (if (= last-open match-open)
                        (rest acc)
                        (cons :invalid acc))
      :ignore-others    acc)))

(defn valid? [s]
    (empty? (reduce balance nil s)))