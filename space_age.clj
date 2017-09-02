(ns space-age)

(defn space-age [age planet-mult]
(let [earth-orbital-period 31557600]
    (/ age planet-mult earth-orbital-period)))

(defn on-earth [age]
    (space-age age 1.0))

(defn on-mercury [age]
    (space-age age 0.2408467))

(defn on-venus [age]
    (space-age age 0.61519726))

(defn on-mars [age]
    (space-age age 1.8808158))

(defn on-jupiter [age]
    (space-age age 11.862615))

(defn on-saturn [age]
    (space-age age 29.447498))

(defn on-uranus [age]
    (space-age age 84.016846))

(defn on-neptune [age]
    (space-age age 164.79132))