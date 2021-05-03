(ns taller ;; name space
  (:require [java-time :as t])) ;; dependencia y alias de esta

(defn time-str ;; declaracion de funcion
  "Returns a string representation of a datetime in the local time zone."
  [instant]
  (t/format
    (t/with-zone (t/formatter "hh:mm a") (t/zone-id))
    instant))

(defn run [opts] ;; declaracion de funcion
  (println "Hola mundo, la hora es: " (time-str (t/instant)))
 )

(defn length
  "Retorna la longitud de una lista usando tail-recursion"
  ([lst] (length 0 lst))
  ([n lst]
    (if (empty? lst)
      n
      (recur (inc n) (rest lst))))
 )

(def a (list 1 2 3 4 0))
(def b (vector))

(defn min-max
  "Retorna el maximo y minimo de una lista"
  [lst]
  (println (apply min lst))
  (println (apply max lst))
  )

(defn collect
  [input]
  (let [input (read-line)]
  (if (= input "0")
    (println "es cero" (conj b 0))
    (println "Diferente de cero" (conj b input))))
 )

(defn collect2
  []
  (case (read-line)
    "0" (println "Lista de vectores: " (conj b 0))
    (do (conj b read-line) (recur)))
  )

(defn quicksort
  "quicksort con recursividad"
  [items]
  (if
   (<= (count items) 1) items  ;; for zero or 1 length collections just return
   (let [pivot   (first items)
         others  (rest items)] ;; don't really need these but aids readability
      (concat
       (quicksort (filter #(>= pivot %) others))
       [pivot]
       (quicksort (filter #(< pivot %) others))))))

(defn generate-triple [n]
  (loop [m (inc n)]
    (let [a (- (* m m) (* n n))
          b (* 2 (* m n)) c (+ (* m m) (* n n)) sum (+ a b c)]
      (if (>= sum 1000)
        [a b c sum]
        (recur (inc m))))))

(defn adder [number]
  (fn [a] (+ number a)))
(def add-ten (adder 10))


(println a)
;;(println (length a) )   ;; punto 1 ;; Quitar ";;" y ejecutar para ver los puntos desarrollados
;;(min-max a)             ;; punto 2
;;(collect read-line)       ;; punto 3
(println (quicksort [1 2 3 0 10 9])) ;; punto 4
;; (println (generate-triple 2)) ;; punto 5
;; (println (add-ten 4)) ;; punto 6

(defn adding [x]
  (+ x x))
