(ns content-items-test
  (:use clojure.test)
  (:require [content-items]
            [helper.test :as test-helper]))

(defn- get-expected-create-content-item-output [input output]
  {:contentItemId (output :contentItemId)
   :name (input :name)
   :url (input :url)
   :text (input :text)
   :headline nil
   :description nil
   :keywords nil
   :learningResourceType nil
   :thumbnail nil
   :image nil
   :moduleImage nil
   :video nil
   :dateCreated nil
   :dateModified nil
   :datePublished nil
   :provider nil
   :publisher nil})

(defn- get-expected-update-content-item-output [input output]
  {:contentItemId (input :content-item-id)
   :name (input :name)
   :url (input :url)
   :text (input :text)
   :headline (output :headline)
   :description (output :description)
   :keywords (output :keywords)
   :learningResourceType (output :learningResourceType)
   :thumbnail (output :thumbnail)
   :image (output :image)
   :moduleImage (output :moduleImage)
   :squareImage (output :squareImage)
   :video (output :video)
   :dateCreated (output :dateCreated)
   :dateModified (output :dateModified)
   :datePublished (output :datePublished)
   :provider (output :provider)
   :publisher (output :publisher)
   :metadata  (output :metadata)})

(defn- get-expected-retrieve-content-item-output [output]
  {:contentItemId (output :contentItemId)
   :name (output :name)
   :url (output :url)
   :text (output :text)
   :headline (output :headline)
   :description (output :description)
   :keywords (output :keywords)
   :learningResourceType (output :learningResourceType)
   :thumbnail (output :thumbnail)
   :image (output :image)
   :moduleImage (output :moduleImage)
   :squareImage (output :squareImage)
   :video (output :video)
   :dateCreated (output :dateCreated)
   :dateModified (output :dateModified)
   :datePublished (output :datePublished)
   :provider (output :provider)
   :publisher (output :publisher)
   :metadata  (output :metadata)})

(defn- get-expected-list-content-item-keys []
  [:contentItemId
   :name
   :url])

(deftest create-content-item
  (let [input           {:name "test-name"
                         :url "https://test/url.com"
                         :text "example text"}
        output          (content-items/create (input :name) (input :url) (input :text))
        expected-output (get-expected-create-content-item-output input output)]
    (is (= expected-output output))))

(deftest update-content-item
  (let [content-items   (content-items/list)
        content-item    (first content-items)
        input           {:content-item-id (content-item :contentItemId)
                         :name            "updated-content-item"
                         :url             "https://updated/content-item.com"
                         :text            "updated example text"}
        output          (content-items/update (input :content-item-id)
                                              (input :name)
                                              (input :url)
                                              (input :text))
        expected-output (get-expected-update-content-item-output input output)]
    (is (= expected-output output))))

(deftest delete-content-item
  (let [content-items   (content-items/list)
        content-item    (first content-items)
        input           {:content-item-id (content-item :contentItemId)}
        output          (content-items/delete (input :content-item-id))
        expected-output "OK"]
    (is (= expected-output output))))

(deftest retrieve-content-item
  (let [content-items   (content-items/list)
        content-item    (first content-items)
        input           {:content-item-id (content-item :contentItemId)}
        output          (content-items/retrieve (input :content-item-id))
        expected-output (get-expected-retrieve-content-item-output output)]
    (is (= expected-output output))))

(deftest list-content-items
  (let [output          (content-items/list)
        expected-output (get-expected-list-content-item-keys)]
    (is (vector? output))
    (is (> (count output) 0))
    (is (test-helper/every-has-values? output expected-output))))

(deftest count-content-items
  (let [output (content-items/count)]
    (is (> output 0))))
