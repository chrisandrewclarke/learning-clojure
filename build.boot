(set-env!
  :resource-paths #{"src" "test"}
  :target "target"
  :dependencies '[[adzerk/boot-test "1.1.1" :scope "test"]
                  [clj-http "2.1.0"]
                  [org.clojure/data.json "0.2.6"]])

(task-options!
  pom {:project 'learn-x-in-y-clojure
       :version "0.1.0"}
  jar {:manifest {"Foo" "bar"}})

(require '[adzerk.boot-test :refer :all])

(deftask build
  "Build my project."
  []
  (comp (test) (pom) (uber) (jar) (target)))
