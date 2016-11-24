(ns recommendations-test
  (:use clojure.test)
  (:require [content-items]
            [recommendations]
            [helper.test :as test-helper]))

(defn- get-expected-retrieve-recommendation-output [output]
  {:relevance (output :relevance)
   :fields (output :fields)
   :contentItemId (output :contentItemId)
   :relationships (output :relationships)})

(deftest test-retrieve-recommendations
  (let [content-items   (content-items/list)
        content-item    (first content-items)
        input           {:content-item-id (content-item :contentItemId)}
        output          (recommendations/retrieve (input :content-item-id))
        ;expected-output (get-expected-retrieve-recommendation-output output)
        ]
    (is (vector? output))
    (is (> (count output) 0))))
    ;(is (test-helper/every-has-values? output expected-output))))
