(ns main-test
  (:use clojure.test)
  (:require [main]))

(deftest happy-path
  (let [result          (main/go)
        expected-result "Hello World!"]
    (is (= expected-result result))))

(deftest hello-world
  (let [result          (main/hello-world)
        expected-result "Hello World!"]
    (is (= expected-result result))))
