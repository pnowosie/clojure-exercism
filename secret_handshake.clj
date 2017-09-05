(ns secret-handshake)

(def cmds [ "wink" "double blink" "close your eyes" "jump" ])

(defn commands [n]
    ((if (bit-test n 4) reverse identity)
    (->> (range 4)
         (filter #(bit-test n %))
         (map cmds))))