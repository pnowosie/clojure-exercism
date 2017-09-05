(ns minesweeper
    (:require [clojure.string :as s]))

(defn parse [strb]
    (mapv vec (s/split-lines strb)))

(defn size [board]
    [(count board) (count (first board))])

(defn safe-get [board [row col]]
    (let [[R C] (size board)]
        (and (< -1 row R) (< -1 col C) (nth (nth board row) col))))

(defn with-neighbors [r c]
    (let [fs        '(-1 0 1)
          rs        (repeat 3 r)
          cs        (repeat 3 c)
          nrs       (map + rs fs)]
        (map list nrs cs)))

(defn ind-around [r c]
    (filter #(not= [r c] %)
        (reduce into [(with-neighbors r (inc c))
                      (with-neighbors r c)
                      (with-neighbors r (dec c))])))

(defn mines-around [board r c]
    (->> (ind-around r c)
         (map (partial safe-get board))
         (filter #{\*})
         count))

(defn draw-field [board r c]
    (let [field (safe-get board [r c])
          mines (mines-around board r c)]
        (cond
                    (= \* field) "*"
                    (zero? mines) " "
                    :else (str mines))))

(defn draw [board]
    (let [board (parse board)
          [R C] (size board)
          drawing (for [r (range R)]
            (map #(draw-field board r %) (range C)))]
        (->> drawing
             (map #(apply str %))
             (s/join \newline))))
