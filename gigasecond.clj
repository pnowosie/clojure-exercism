(ns gigasecond
    (:import java.util.Calendar))

(defn from [y m d]
    (let    [gigaseconds (* 1000 1000 1000)
             year  #(.get % Calendar/YEAR)
             month #(inc (.get % Calendar/MONTH))
             day   #(.get % Calendar/DATE)
             ymd (juxt year month day)]
        
        (ymd (doto (Calendar/getInstance)
             (.set y (dec m) d 0 0 0)
             (.add Calendar/SECOND gigaseconds)
        ))
    )
)