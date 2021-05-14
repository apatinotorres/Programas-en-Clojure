(ns paralelo)

(defn mapparalelo
    {:added "1.0"
   :static true}
  ([f coll]
   (let [n (+ 2 (.. Runtime getRuntime availableProcessors))
         rets (map #(future (f %)) coll)
         step (fn step [[x & xs :as vs] fs]
                (lazy-seq
                 (if-let [s (seq fs)]
                   (cons (deref x) (step xs (rest s)))
                   (map deref vs))))]
     (step rets (drop n rets))))
  ([f coll & colls]
   (let [step (fn step [cs]
                (lazy-seq
                 (let [ss (map seq cs)]
                   (when (every? identity ss)
                     (cons (map first ss) (step (map rest ss)))))))]
     (mapparalelo #(apply f %) (step (cons coll colls))))))


(defn numero_telefonico
  [string]
  (re-seq #"(\d{3})[\.-]?(\d{3})[\.-]?(\d{4})" string))
(numero_telefonico " Sunil: 617.555.2937, Betty: 508.555.2218")

(def files (repeat 100
  (apply str
      (concat (repeat 1000000 \space)
      "Sunil: 617.555.2937, Betty: 508.555.2218"))))

(time (dorun (map numero_telefonico files)))
;; (time (dorun (pmap numero_telefonico files)))
(time (dorun (mapparalelo numero_telefonico files)))

(defn main [opts]
  (print "hola mundo"))
