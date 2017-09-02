(ns sieve)

(defn is-prime? [n]
    (let [Q (inc (Math/sqrt n))
          n-odd (or (= 2 n)
                    (not= 0 (mod n 2)))]
        (and n-odd
             (not-any? #(zero? (mod n %)) (range 3 Q 2)))))

(defn range-n [n]
    (iterate inc (inc n)))

(defn next-prime [n]
    (->> (range-n n) (drop-while (complement is-prime?)) first))

(def gen-primes
    (iterate next-prime 2))

(defn sieve [n]
    (->> gen-primes
         (take-while #(<= % n))))