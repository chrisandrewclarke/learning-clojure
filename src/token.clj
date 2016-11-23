(ns token
  (:require [clj-http.client :as http-client]
            [clojure.data.json :as json]))

(defn create []
  (let [client-id          "cccb3293"
        client-secret      "ca89360451022acd3c672c84ce658913"
        endpoint           "https://api.bibblio.org/token"
        body               (str "client_id=" client-id "&client_secret=" client-secret)
        headers            {:content-type "application/x-www-form-urlencoded"}
        response           (http-client/post endpoint {:body body
                                                       :headers headers})
        response-body      (response :body)
        response-body-json (json/read-str response-body
                                          :key-fn keyword)]
    response-body-json))
