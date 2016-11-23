(ns helper.api
  (:require [clj-http.client :as http-client]
            [clojure.data.json :as json]
            [token]))

(defn- get-authorization-header-value []
  (let [access-token (token/create)
        header-value (str (access-token :token_type) " " (access-token :access_token))]
    header-value))

(defn get-response [request-url]
  (let [headers            {"Authorization" (get-authorization-header-value)}
        raw-response-body  ((http-client/get request-url {:headers headers}) :body)
        json-response-body (json/read-str raw-response-body
                                          :key-fn keyword)]
    json-response-body))

(defn post-response [request-url body]
  (let [headers            {"Authorization" (get-authorization-header-value)}
        json-encoded-body  (json/write-str body)
        raw-response-body  ((http-client/post request-url {:headers headers
                                                           :body json-encoded-body
                                                           :content-type :json}) :body)
        json-response-body (json/read-str raw-response-body
                                          :key-fn keyword)]
    json-response-body))

(defn put-response [resource-url body]
  (let [headers            {"Authorization" (get-authorization-header-value)}
        json-encoded-body  (json/write-str body)
        raw-response-body  ((http-client/put resource-url {:headers headers
                                                           :body json-encoded-body
                                                           :content-type :json}) :body)
        json-response-body (json/read-str raw-response-body
                                          :key-fn keyword)]
    json-response-body))

(defn delete-response [resource-url]
  (let [headers           {"Authorization" (get-authorization-header-value)}
        raw-response-body ((http-client/delete resource-url {:headers headers}) :body)]
    raw-response-body))
