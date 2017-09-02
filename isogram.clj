(ns isogram
    (:require [clojure.string :as str]))

(defn isogram? [s]
    (let [s (str/lower-case
                (str/replace s #"[\s\-\_]" ""))]
        (every? #{1} (vals (frequencies s)))))