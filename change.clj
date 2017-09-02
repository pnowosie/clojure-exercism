(ns change)

(def impossible '())

(defn better [actual-best proposed]
    (cond
        (empty? proposed) actual-best
        (empty? actual-best) proposed
        (< (count proposed) (count actual-best)) proposed
        :else actual-best))

(defn change [amount coins actual best]  
(cond 
    (empty? coins) best
    (zero? amount) actual
    (neg? amount)  impossible

    :else
    (let [coins     (remove #(> % amount) coins)
          highest   (and (seq coins) (first coins))
          aprox     (when highest (+ (count actual) (quot amount highest)))
          continue  (when highest (or (empty? best) (< aprox (count best))))]
        
        (if-not continue
            impossible

            (let [best-so-far 
                    (better best 
                        (change (- amount highest) coins (cons highest actual) best))]
                
                (better best-so-far
                    (change amount (rest coins) actual best-so-far))))
    )
))

(defn issue [amount coins] 
    (let [coins (reverse (sort coins))]
      (and (not= 0 amount) (> (last coins) amount) (throw (IllegalArgumentException. "cannot change")))
      (change amount coins '() '())))