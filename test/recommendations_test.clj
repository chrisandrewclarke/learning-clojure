(ns recommendations-test
  (:use clojure.test)
  (:require [content-items]
            [recommendations]
            [helper.test :as test-helper]))

(defn- get-expected-retrieve-recommendation-output-keys []
  [:relevance
   :fields
   :contentItemId
   :relationships])

(deftest test-retrieve-recommendations
  (let [content-items   (content-items/list)
        content-item    (first content-items)
        input           {:content-item-id (content-item :contentItemId)}
        output          (recommendations/retrieve (input :content-item-id))
        expected-output (get-expected-retrieve-recommendation-output-keys)]
    (is (vector? output))
    (is (> (count output) 0))
    (is (test-helper/every-has-values? output expected-output))))
