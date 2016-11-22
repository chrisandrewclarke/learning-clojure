(ns helper.foobar
  (:require [clj-http.client :as http-client]
            [clojure.data.json :as json]
            [token]))

(defn get-response [request-url]
  (let [access-token       (token/create)
        headers            {:headers {
                             :Authorization access-token}}
        raw-response-body  ((http-client/get request-url headers) :body)
        json-response-body (json/read-str raw-response-body
                                          :key-fn keyword)]
    json-response-body))

(defn post-response [request-url body]
  (let [access-token       (token/create)
        headers            {"Authorization" access-token}
        json-encoded-body  (json/write-str body)
        raw-response-body  ((http-client/post request-url {:headers headers
                                                           :body json-encoded-body
                                                           :content-type :json}) :body)
        json-response-body (json/read-str raw-response-body
                                          :key-fn keyword)]
    json-response-body))

(defn put-response [resource-url body]
  (let [access-token       (token/create)
        headers            {"Authorization" access-token}
        json-encoded-body  (json/write-str body)
        raw-response-body  ((http-client/put resource-url {:headers headers
                                                           :body json-encoded-body
                                                           :content-type :json}) :body)
        json-response-body (json/read-str raw-response-body
                                          :key-fn keyword)]
    json-response-body))

(defn delete-response [resource-url]
  (let [access-token      (token/create)
        headers           {"Authorization" access-token}
        raw-response-body (http-client/delete resource-url {:headers headers})]
    raw-response-body))
