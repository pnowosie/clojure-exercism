(ns robot-simulator)

(defn turn-right [bearing]
    (case bearing
        :north :east
        :east  :south
        :south :west
        :west  :north))

(defn turn-left [bearing]
    (case bearing
        :north :west
        :east  :north
        :south :east
        :west  :south))

(defn accelerate [{ {:keys [x y]} :coordinates bearing :bearing }]
        (case bearing
            :north { :x x        :y (inc y) }
            :east  { :x (inc x)  :y      y  }
            :south { :x x        :y (dec y) }
            :west  { :x (dec x)  :y      y  }))

(defn execute [state step]
    (merge state 
        (case step
            \R   { :bearing     (turn-right (:bearing state)) }
            \L   { :bearing     (turn-left  (:bearing state)) }
            \A   { :coordinates (accelerate state)            })))

(defn robot [coords bearing]
    { :coordinates coords :bearing bearing })

(defn simulate [commands robot]
        (reduce execute robot commands))