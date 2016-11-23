(ns token-test
  (:use clojure.test)
  (:require [token]))

(defn- get-expected-create-token-output [output]
  {:access_token   (output :access_token)
   :token_type    (output :token_type)
   :expires_in (output :expires_in)})

(deftest create-token
  (let [output (token/create)
        expected-output (get-expected-create-token-output output)]
    (is (= output expected-output))))
