(ns clock)

(def minutes-in-day (* 24 60))

(defn clock [hours mins]
  (mod (+ (* 60 hours) mins) minutes-in-day))

(defn add-time [clock mins]
  (mod (+ clock mins) minutes-in-day))

(defn clock->string [clock]
  (format "%02d:%02d" (quot clock 60) (mod clock 60)))
