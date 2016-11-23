(ns helper.test
  (:use clojure.test))

(defn has-values? [m ks]
  (every? #(get m %) ks))

(defn every-has-values? [ms ks]
  (every? #(has-values? % ks) ms))
