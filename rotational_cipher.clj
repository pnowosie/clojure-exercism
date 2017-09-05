(ns rotational-cipher)

(defn rotor [n c]
    (let [B (int (if (Character/isUpperCase c) \A \a))]
        (char (+ B (mod (+ n (- (int c) B)) 26)))))

(defn transform [n c]
    (if (Character/isLetter c) (rotor n c) c))

(defn rotate [s n]
    (clojure.string/escape s #(transform n %)))