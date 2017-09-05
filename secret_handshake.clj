(ns secret-handshake)

(def cmds {
    1 "wink"
    2 "double blink"
    4 "close your eyes"
    8 "jump"
})

(defn commands [n]
    ((if (bit-test n 4) reverse identity)
    (->> cmds
         keys
         (map #(cmds (bit-and n %)))
         (remove nil?))))