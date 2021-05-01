(ns hello ;; name space
  (:require [java-time :as t])) ;; dependencia y alias de esta

(defn time-str ;; declaracion de funcion
  "Returns a string representation of a datetime in the local time zone."
  [instant]
  (t/format
    (t/with-zone (t/formatter "hh:mm a") (t/zone-id))
    instant))

(defn run [opts] ;; declaracion de funcion
  (println "Hola mundo, la hora es: " (time-str (t/instant))))

(defn do-stuff [x z]
  (* x z))

(defn func [x y & z]
  (+ x y)
  (fn [x]
    (do-stuff x z)))


(defn foo [x y]
  (println x y)
  (recur (inc x) (dec y))) ;; salta al inicio de la funcion
                           ;;con nuevos argumentos, recursiva hasta el infinito

(defn foo2 [x y]
  (println x y)
  (if (< x 100)
    (recur (inc x) (dec y))))

(defn factorial [n]
  (if (= n 0) 1
    (* n (factorial (dec n)))))



(println (factorial 20))
;;(foo2 1 100)
;;(foo 0 100)
;;(println (do-stuff 2 5))
;;(func 1 2)
;;(func 1 2 7)
