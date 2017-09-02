(ns robot-name)

(def symbols "ABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn gen-name []
  (format "%s%s%03d"
          (rand-nth symbols)
          (rand-nth symbols)
          (rand-int 1000)))

(def all-names (atom #{}))

(defn new-name []
  (loop [name (gen-name)]
    (if (contains? @all-names name)
        (recur (gen-name))
        (do (swap! all-names conj name)
          name))))

(defn robot []
  (atom (new-name)))

(defn robot-name [robot]
  (str @robot))

(defn reset-name [robot]
  (reset! robot (new-name)))

