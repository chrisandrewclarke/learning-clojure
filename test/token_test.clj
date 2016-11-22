(ns token-test
  (:use clojure.test)
  (:require [content-items]))

(deftest go
  (let [create-content-item   (content-items/create "test name" "http://www.example.com" "example text")
        update-content-item   (content-items/update (create-content-item :contentItemId) "updated-name" "https://url.com" "updated-text")
        retrieve-content-item (content-items/retrieve (update-content-item :contentItemId))
        delete-content-item   (content-items/delete retrieve-content-item)
        count-content-items   (content-items/count)
        list-content-items    (content-items/list)
        expected-result       "Hello World!"]
    (is (= expected-result list-content-items))))
