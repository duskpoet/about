(ns about.blog.core
  (:require
   [about.blog.html :as blog-html]
   [clj-http.client :as http]
   [clojure.java.io :as io]
   [clojure.java.shell :refer [sh]]
   [clojure.string :as string]
   [markdown.core :as markdown]))


(def blogs
  (->>
    (io/resource "blogs.edn")
    (slurp)
    (read-string)
    (map (fn [blog]
           (assoc blog
                  :content
                  (-> (http/get (blog :url))
                      :body
                      (markdown/md-to-html-string)
                      (string/replace #"href='\./" (str "href='" (blog :base-url)))))))
    (map (fn [blog]
           (assoc blog
                  :title
                  (->> (blog :content)
                       (re-find #"\<h1\>(.*)\<\/h1\>")
                       second))))
    vec))

(defn build-blogs [out]
  (spit (io/file out "blog.html") (blog-html/blogs-html blogs))
  (sh "mkdir" (str out "/blog"))
  (doseq [blog blogs]
    (spit (io/file out "blog" (str (blog :slug) ".html")) (blog-html/artictle-html blog))))
