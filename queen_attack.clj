(ns queen-attack)

(defn board-string [m]
(let [pos 
        (reduce (fn [m [q p]] (assoc m p ({:w \W :b \B} q))) {} m)
      board 
        (for [x (range 8)] (map #(get pos [x %] \_) (range 8)))]
  (->>  board
        (map (partial reduce #(str %1 " " %2)))
        (reduce #(str %1 %2 "\n") ""))))

(defn can-attack [{:keys [w b]}] 
(let [[wx wy] w
      [bx by] b
      attack-row  (= wx bx)
      attack-col  (= wy by)
      attack-diag (= (Math/abs (- wx bx)) (Math/abs (- wy by)))] 
    (or attack-row attack-col attack-diag)))
