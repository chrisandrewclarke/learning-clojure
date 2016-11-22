(ns main-test
  (:use clojure.test)
  (:require [main]))

(deftest go
  (let [result          (main/go)
        expected-result "Hello World!"]
    (is (= expected-result result))))

(deftest happy-path
  (let [result          (main/hello-world)
        expected-result "Hello World!"]
    (is (= expected-result result))))

(deftest addition
  (let [result          (main/addition)
        expected-result 3]
    (is (= expected-result result))))

(deftest subtraction
  (let [result          (main/subtraction)
        expected-result 3]
    (is (= expected-result result))))

(deftest multiplication
  (let [result          (main/multiplication)
        expected-result 3]
    (is (= expected-result result))))

(deftest division
  (let [result          (main/division)
        expected-result 3]
    (is (= expected-result result))))

(deftest equality-one
  (let [result          (main/equality-one)
        expected-result false]
    (is (= expected-result result))))

(deftest equality-two
  (let [result          (main/equality-two)
        expected-result true]
    (is (= expected-result result))))

(deftest not-true
  (let [result          (main/not-true)
        expected-result true]
    (is (= expected-result result))))

(deftest nesting-forms
  (let [result          (main/nesting-forms)
        expected-result 1]
    (is (= expected-result result))))

(deftest inspect-object-type-one
  (let [result          (main/inspect-object-type-one)
        expected-result 1]
    (is (= expected-result result))))

(deftest inspect-object-type-one-dot
  (let [result          (main/inspect-object-type-one-dot)
        expected-result 1]
    (is (= expected-result result))))

(deftest inspect-object-string
  (let [result          (main/inspect-object-string)
        expected-result "not-string"]
    (is (= expected-result result))))

(deftest inspect-object-false
  (let [result          (main/inspect-object-false)
        expected-result 1]
    (is (= expected-result result))))

(deftest inspect-object-nil
  (let [result          (main/inspect-object-nil)
        expected-result 1]
    (is (= expected-result result))))

(deftest literal-list
  (let [result          (main/literal-list)
        expected-result 1]
    (is (= expected-result result))))

(deftest eval-quoted-list
  (let [result          (main/eval-quoted-list)
        expected-result 1]
    (is (= expected-result result))))

(deftest vector-example
  (let [result          (main/vector-example)
        expected-result 1]
    (is (= expected-result result))))

(deftest list-example
  (let [result          (main/list-example)
        expected-result 1]
    (is (= expected-result result))))

(deftest collection-list
  (let [result          (main/collection-list)
        expected-result 1]
    (is (= expected-result result))))

(deftest collection-vector
  (let [result          (main/collection-vector)
        expected-result 1]
    (is (= expected-result result))))

(deftest is-sequence
  (let [result          (main/is-sequence)
        expected-result 1]
    (is (= expected-result result))))

(deftest not-sequence
  (let [result          (main/not-sequence)
        expected-result 1]
    (is (= expected-result result))))

(deftest range-4
  (let [result          (main/range-4)
        expected-result 1]
    (is (= expected-result result))))

; (deftest range-example
;   (let [result          (main/range-example)
;         expected-result 1]
;     (is (= expected-result result))))

(deftest range-take-4
  (let [result          (main/range-take-4)
        expected-result 1]
    (is (= expected-result result))))

(deftest cons-add-to-vector
  (let [result          (main/cons-add-to-vector)
        expected-result 1]
    (is (= expected-result result))))

(deftest cons-add-to-list
  (let [result          (main/cons-add-to-list)
        expected-result 1]
    (is (= expected-result result))))

(deftest conj-vector-add-to-end
  (let [result          (main/conj-vector-add-to-end)
        expected-result 1]
    (is (= expected-result result))))

(deftest conj-list-add-to-start
  (let [result          (main/conj-list-add-to-start)
        expected-result 1]
    (is (= expected-result result))))

(deftest concat-example
  (let [result          (main/concat-example)
        expected-result 1
        expected-result 2]
    (is (= expected-result result))))

(deftest map-example
  (let [result          (main/map-example)
        expected-result 1]
    (is (= expected-result result))))

(deftest filter-example
  (let [result          (main/filter-example)
        expected-result 1]
    (is (= expected-result result))))

(deftest reduce-example
  (let [result          (main/reduce-example)
        expected-result 1]
    (is (= expected-result result))))

(deftest reduce-conj-example
  (let [result          (main/reduce-conj-example)
        expected-result 1]
    (is (= expected-result result))))
