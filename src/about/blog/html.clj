(ns about.blog.html
  (:require
   [about.html :refer [nav-bar]]
   [hiccup.page :refer [html5 include-css]]))

(defn blogs-html [blogs]
  (html5
    [:head
      [:meta {:http-equiv "content-type" :content "text/html; charset=utf-8"}]
      [:meta {:name "viewport" :content "width=device-width,initial-scale=1.0,viewport-fit=cover"}]
      [:title "Eduard's blog"]
      (include-css "assets/tui/tuicss.min.css")
      (include-css "style.css")]
    [:body
      (nav-bar)
      [:div.content.tui-bg-cyan-white.blue-168-text.center
        [:div.container
         [:div.row
          [:div.col.s12.m8.l8.offset-m2.offset-l2
           "These are articles I've written on various topics and want to share with anyone who is interested"]]
         [:section.articles.left-align
           (for [blog blogs]
            [:div.row
             [:div.col.s12.m12.l12
              [:h2 
               [:a {:href (str "blog/" (blog :slug) ".html")}
                 (blog :title)]]
              [:span (blog :date)]
              [:br][:br]
              [:a {:href (blog :github)} "Github"]]])]]]]))

(defn artictle-html [blog]
  (html5
    [:head
      [:meta {:http-equiv "content-type" :content "text/html; charset=utf-8"}]
      [:meta {:name "viewport" :content "width=device-width,initial-scale=1.0,viewport-fit=cover"}]
      [:title "Eduard's blog"]
      (include-css "../assets/tui/tuicss.min.css")
      (include-css "../style.css")]
    [:body
      (nav-bar)
      [:div.bg-article
        [:div.container.article
         [:div.row
          [:div.col.s12.m8.l8
           [:a {:href (:github blog)} "Github"]
           [:br]
           (blog :content)]]]]]))
  
