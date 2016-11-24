(ns recommendations
  (:require [helper.api :as api]))

(def resource-url "https://api.bibblio.org/v1/content-items/")

(defn- get-request-url [content-item-id]
    (let [limit           "?limit=1"
          page            "&page=1"
          fields          "&fields=url"
          recommendations "/recommendations"
          request-url     (str resource-url "/" content-item-id recommendations limit page fields)]
      request-url))

(defn retrieve [content-item-id]
  (let [request-url   (get-request-url content-item-id)
        response      (api/get-response request-url)
        content-items (response :results)]
    content-items))
