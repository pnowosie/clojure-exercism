(ns bank-account)

(defn bank-account/open-account []
    (atom 0))

(defn get-balance [acc]
    @acc)

(defn update-balance [acc amount]
    (and @acc   ;; check whether account wasn't closed
        (swap! acc #(+ amount %))))

(defn close-account [acc]
    (reset! acc nil))