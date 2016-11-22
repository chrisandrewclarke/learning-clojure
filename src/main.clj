(ns main)

(defn go []
  (- 2 1 1))

(defn hello-world [] "Hello World")

(defn addition []
  (+ 1 1))

(defn subtraction []
  (- 2 1))

(defn multiplication []
  (* 1 2))

(defn division []
  (/ 2 1))

(defn equality-one []
  (= 1 1))

(defn equality-two []
  (= 2 1))

(defn not-true []
  (not true))

(defn nesting-forms []
  (+ 1 (- 3 2)))

(defn inspect-object-type-one []
  (class 1))

(defn inspect-object-type-one-dot []
  (class 1.))

(defn inspect-object-string []
  (class ""))

(defn inspect-object-false []
  (class false))

(defn inspect-object-nil []
  (class nil))

(defn literal-list []
  '(+ 1 2))

(defn eval-quoted-list []
  (eval '(+ 1 2)))

(defn vector-example []
  (class [1 2 3]))

(defn list-example []
  (class '(1 2 3)))

(defn collection-list []
  (coll? '(1 2 3)))

(defn collection-vector []
  (coll? [1 2 3]))

(defn is-sequence []
  (seq? '(1 2 3)))

(defn not-sequence []
  (seq? [1 2 3]))

(defn range-4 []
  (range 4))

; (defn range-example []
;   (range))

(defn range-take-4 []
  (take 4 (range)))

(defn cons-add-to-vector []
  (cons 4 [1 2 3]))

(defn cons-add-to-list []
  (cons 4 '(1 2 3)))

(defn conj-vector-add-to-end []
  (conj [1 2 3] 4))

(defn conj-list-add-to-start []
  (conj '(1 2 3) 4))

(defn concat-example []
  (concat [1 2] [3 4]))

(defn map-example []
  (map inc [2 3 4]))

(defn filter-example []
  (filter even? [1 2 3]))

(defn reduce-example []
  (reduce + [1 2 3 4]))

(defn reduce-conj-example []
  (reduce conj [] '(3 2 1)))
