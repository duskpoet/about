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
        [:iframe.tui-bg-orange-white {:src "/me.html"}]]]
      [:section.job-exp.tui-window
        [:fieldset.tui-fieldset
          [:legend "Job experience"]
          [:div.job
            [:div.place "Yandex"]
            [:div.job-title "Frontend dev. Since Apr. 2018"]
            [:p.job-description "Developed web app for analytical tracking system"]
            [:p.job-notable "Introduced redux, redux-saga, react and typescript into project from scratch. Developed applicative library for redux. Gave series of lectures and masterclasses about typescript, redux, redux-saga"]]
          [:div.job
            [:div.place "bolt.com"]
            [:div.job-title "Frontend dev. Since Oct. 2016"]
            [:p.job-description "Developed web checkout app, advertising site"]
            [:p.job-notable "Wrote integration scripts for external ecommerce platforms. Build advertising web-site from scratch solo."]]
          [:div.job
            [:div.place "Mail.ru Group"]
            [:div.job-title "Frontend dev. Since Aug. 2015"]
            [:p.job-description "Developed web app for analytical tracking system"]
            [:p.job-notable "Wrote cartographic report from scratch (including retrieving raw maps and converting them to web format). Worked on a huge advertising platform with 7 teammates."]]]]
      [:section.links
        (link "mailto:bird.duskpoet@gmail.com" "Email")
        (link "https://github.com/duskpoet" "Github")
        (link "https://t.me/duskpoet" "Tg")]]]))
