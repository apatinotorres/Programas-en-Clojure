(ns aproximacion)


;; Antonio Jose Patiño Torres T00056470

;; sea un circulo r = 1/2
;; A = pi r^2
;; su area va a ser a 1/4 de pi
;; perimetro = 2r pi
;; pi = perimetro / 2r   por lo tanto -> perimetro = pi
;; c_interno = n sen(180/n)
;; c_externo = n tan(180/n)

(defn main [opts]
  (println "hola mundo"))


(defn outer_p [n]
  (* n
     (Math/tan (Math/toRadians (/ 180 n)))))

(defn inner_p [n]
  (* n
     (Math/sin (Math/toRadians (/ 180 n)))))

(defn unicode [code]
  (-> (Character/toChars code)
      String.))

(defn prueba
      [z l]
      (printf "esto es una prueba %1.26f es una un numero: %2s otro numero: %3.16f" (inner_p z) (unicode 0x03C0) (outer_p l)))

; (prueba 4 5)

(defn arquimides_pi
  "Calcula Pi usando las ideas de arquimides, con poligonos regulares internos y externos"
  [x y]
  (printf " %1.16f < %2s < %3.16f innergon: %4d outergon: %5d %n" (inner_p x) (unicode 0x03C0) (outer_p y) x y )
  (recur (inc x) (inc y)))

; (arquimides_pi 3 3)

(defn calculate-pi
  "Calcula Pi usando la aproximacion 4 * (1 - 1/3 + 1/5 - 1/7 + …)"
  [iterations]
  (* 4.0 (reduce + (map eval (partition 2 (interleave (cycle '(+ -)) (map #(/ 1.0 %) (take iterations (filter odd? (iterate inc 1))))))))))

(println "calculated pi = " (calculate-pi 10000))
(println "Math.PI       = " (. Math PI))
