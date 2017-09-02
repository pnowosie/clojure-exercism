(ns raindrops)

(defn convert [n]
  (let [ms (map #(when (zero? (mod n %1)) %2) 
                [3 5 7] 
                ["Pling" "Plang" "Plong"])]
  (apply str (or (seq (filter some? ms)) [n]))))