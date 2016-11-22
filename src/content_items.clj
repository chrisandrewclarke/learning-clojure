(ns content-items
  (:require [helper.foobar :as foobar]))

(def resource-url "https://api.bibblio.org/v1/content-items")

(defn- get-request-url
  ([]
    (let [limit       "?limit=10"
          page        "&page=1"
          fields      "&fields=name%2Curl"
          request-url (str resource-url limit page fields)]
      request-url))
  ([content-item-id]
    (let [request-url (str resource-url "/" content-item-id)]
      request-url)))

(defn create [name url text]
  (let [body     {:name name :url url :text text}
        response (foobar/post-response resource-url body)]
    response))

(defn update [content-item-id name url text]
  (let [body         {:name name :url url :text text}
        resource-url (get-request-url content-item-id)
        response     (foobar/put-response resource-url body)]
    response))

(defn retrieve [content-item-id]
  (let [request-url (get-request-url content-item-id)
        response    (foobar/get-response request-url)]
    response))

(defn delete [retrieved-content-item]
  (let [content-item-id (retrieved-content-item :contentItemId)
        resource-url    (get-request-url content-item-id)
        response        (foobar/delete-response resource-url)]
    response))

(defn count []
  (let [count-resource-url (str resource-url "/count")
        response           (foobar/get-response count-resource-url)]
    response))

(defn list []
  (let [request-url   (get-request-url)
        response      (foobar/get-response request-url)
        content-items (response :results)]
    content-items))
