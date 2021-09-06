(ns about.core
  (:require [about.html :refer [html]]
            [about.css :refer [css]]
            [clojure.java.io :as io]
            [clojure.java.shell :refer [sh]])
  (:gen-class))

(def OUT "docs")

(defn build-html []
  (spit (io/file OUT "index.html") (html)))

(defn build-css []
  (spit (io/file OUT "style.css") (css)))

(defn build-assets []
  (sh "cp" "-rf" "resources/assets/" "docs/"))

(defn clean []
  (sh "rm" "-rf" OUT))

(defn mkdir []
  (sh "mkdir" OUT))

(defn build []
  (clean)
  (mkdir)
  (build-assets)
  (build-html)
  (build-css))

(defn -main [& args]
  (println "Statring build")
  (build)
  (println "Done!")
  (System/exit 0))
