(ns about.html
  (:require [hiccup.page :refer [html5 include-css]]
            [java-time :as jt]))

(def BIRTH_DATE (jt/local-date 1990 11 2))
(def AGE (jt/time-between BIRTH_DATE (jt/local-date) :years))

(defn link [url & content]
  [:a {:href url :target "_blank"}
   (vec (cons :button.tui-button content))])

(defn html []
  (html5
   [:head
    [:meta {:http-equiv "content-type" :content "text/html; charset=utf-8"}]
    [:title "About Eduard's professional skills"]
    (include-css "tui/tuicss.min.css")
    (include-css "style.css")]
   [:body
    [:div.content.tui-bg-yellow-white.center
     [:section.about-me.tui-window
      [:div.info-me.white-255-text
       [:label "Name........:"]
       [:span.value "Eduard Dyckman"]
       [:br]
       [:label "Age.........:"]
       [:span.value AGE]
       [:br]
       [:label "From........:"]
       [:span.value "Moscow"]
       [:br]
       [:label "Main skills.:"]
       [:span.skills
        [:span.skill "typescript"
         [:span.skill-js "java"]]
        [:span.skill "node"]
        [:span.skill "react"]
        [:span.skill "git"]]
       [:br]
       [:label "Confident in:"]
       [:span.skills
        [:span.skill "clojure"]
        [:span.skill "sql"]
        [:span.skill "mongo"]]
       [:label "Some skills.:"]
       [:span.skills
        [:span.skill "python"]
        [:span.skill "docker"]
        [:span.skill "nginx"]
        [:span.skill "clickhouse"]
        [:span.skill "c"]]]
      [:div.photo
       [:iframe.tui-bg-orange-white {:src "me.html"}]]]
     [:section.job-exp.tui-window
      [:fieldset.tui-fieldset
       [:legend "Job experience"]
       [:div.job
        [:div.title "Yandex"]
        [:div.job-title "Frontend dev. Since Apr. 2018"]
        [:p.job-description "Developed web app for analytical tracking system"]
        [:ul.job-notable
         [:li "Introduced redux, redux-saga, react and typescript into project from scratch"]
         [:li "Developed applicative library for redux"]
         [:li "Gave series of lectures and masterclasses about typescript, redux, redux-saga"]]]
       [:div.job
        [:div.title "bolt.com"]
        [:div.job-title "Frontend dev. Since Oct. 2016"]
        [:p.job-description "Developed web checkout app, advertising site"]
        [:ul.job-notable
         [:li "Wrote integration scripts for external ecommerce platforms"]
         [:li "Build advertising web-site from scratch solo"]]]
       [:div.job
        [:div.title "Mail.ru Group"]
        [:div.job-title "Frontend dev. Since Aug. 2015"]
        [:p.job-description "Developed web app for analytical tracking system"]
        [:ul.job-notable
         [:li "Wrote cartographic report from scratch (including retrieving raw maps and converting them to web format"]
         [:li "Worked on a huge advertising platform with 7 teammates"]]]
       [:div.job
        [:div.title "Undev"]
        [:div.job-title "Frontend ninja. Since Dec. 2013"]
        [:p.job-description "Developed various frontends"]
        [:ul.job-notable
         [:li "Wrote frontend for video broadcast service of state elections and examinations"]
         [:li "Optimized and refactored module for producing clustered geo data"]
         [:li "Wrote game app and media transmit protocol for Smart TV"]]]]]
     [:section.edu.tui-window
      [:fieldset.tui-fieldset
       [:legend "Education"]
       [:p.description "MSU, Faculty of Computational Mathematics and Cybernetics with master’s degree in “Applied Mathematics and Computer Science”, 2007 &mdash; 2013"]]]
     [:section.links
      (link "mailto:bird.duskpoet@gmail.com" "Email")
      (link "https://habr.com/ru/post/522864" "Habr")
      (link "https://github.com/duskpoet" "Github")
      (link "https://t.me/duskpoet" "Tg")]]]))
