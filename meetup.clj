(ns meetup
    (require [clj-time.core :as t]))

(def time->days { 1 :monday, 2 :tuesday, 3 :wednesday, 4 :thursday,  5 :friday, 6 :saturday, 7 :sunday })

(defn days-range [start end]
    (loop [days [ start ]]
        (let [last-day (last days)
              next-day (t/plus last-day (t/days 1))]
            (if (t/after? next-day end)
                days
                (recur (conj days next-day))))))

(defn days-in-month [mth yr]
    (map #(list (time->days (t/day-of-week %)) (t/day %))
        (days-range (t/date-time yr mth 1) (t/last-day-of-the-month yr mth))))

(defn meetup [mth yr wd which]
(let [meet-at ({
            :first  first
            :second second
            :third  #(nth % 2)
            :fourth #(nth % 3)
            :last   last
            :teenth #(some (fn [[_ n :as day]] 
                             (and (< 12 n) (> 20 n) day)) %)
       } which)]
    (->> (days-in-month mth yr)
         (filter #(= wd (first %)))
         meet-at
         second
         (conj [yr mth]))))