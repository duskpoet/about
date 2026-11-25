(ns about.html
  (:require [hiccup.page :refer [html5 include-css]]
            [clojure.string :as string]
            [java-time :as jt]))

(def BIRTH_DATE (jt/local-date 1990 11 2))
(def AGE (jt/time-between BIRTH_DATE (jt/local-date) :years))
(def BASE "https://duskpoet.github.io/about/")

(defn sanitize-link [url] (string/replace-first url "mailto:" ""))

(defn link-pads
  [content]
  (let [size (apply + (map count content))]
    (string/join (repeat (- 10 size) " "))))

(defn link
  [url & content]
  [:a {:href url} (vec (cons :button.tui-button content))
   [:span.link-pads (link-pads content)] [:span.link-href (sanitize-link url)]])

(defn job
  "A job entry on the timeline. The job's left border is the timeline line;
  `since` (\"Jun 2022\") is marked by a horizontal tick below the job, showing
  the year with the month revealed on hover. Jobs go newest first, so the top
  of the line is the present."
  [title role since & body]
  (let [[month year] (string/split since #" ")]
    [:div.job
     (into [:div.job-body [:div.title title] [:div.job-title role]] body)
     [:div.job-since
      [:time {:datetime year} [:span.since-month (str month " ")] year]]]))

(defn nav-bar
  []
  [:nav.tui-nav
   [:ul [:li [:a {:href (str BASE "index.html")} "Home"]]
    [:li [:a {:href (str BASE "blog.html")} "Blog"]]]])

(defn html
  []
  (html5
   [:head
    [:meta {:http-equiv "content-type", :content "text/html; charset=utf-8"}]
    [:meta
     {:name "viewport",
      :content "width=device-width,initial-scale=1.0,viewport-fit=cover"}]
    [:link {:rel "icon", :href "assets/favicon.ico"}]
    [:meta {:name "description", :content "Eduard Dykman is a full-stack engineer with 13+ years of experience building developer platforms, cloud infrastructure, and AI-integrated software."}]
    [:meta {:name "keywords", :content "Eduard Dykman, software engineer, full-stack developer, developer platforms, cloud infrastructure, AI, typescript, node, go"}]
    [:meta {:name "author", :content "Eduard Dykman"}]
    [:meta {:property "og:title", :content "About Eduard Dykman"}]
    [:meta {:property "og:description", :content "Eduard Dykman is a full-stack engineer with 13+ years of experience building developer platforms, cloud infrastructure, and AI-integrated software."}]
    [:title "About Eduard's professional skills"]
    (include-css "assets/tui/tuicss.min.css") (include-css "style.css")]
   [:body (nav-bar)
    [:div.content.tui-bg-yellow-white.center
     [:section.about-me.tui-window
      [:div.info-me.white-255-text [:label "Name........:"]
       [:span.value "Eduard Dykman"] [:br] [:label "Age.........:"]
       [:span.value AGE] [:br] [:label "Based.......:"] [:span.value "Cambridge, UK"]
       [:br] [:label "Main skills.:"]
       [:span.skills [:span.skill "claude"] [:span.skill "typescript" [:span.skill-js "java"]]
        [:span.skill "node"] [:span.skill "git"]] [:br]
       [:label "Confident in:"]
       [:span.skills [:span.skill "go"] [:span.skill "clojure"]
        [:span.skill "sql"]] [:br] [:label "Some skills.:"]
       [:span.skills [:span.skill "python"] [:span.skill "rust"] [:span.skill "docker"]
        [:span.skill "kubernetes"] [:span.skill "postgres"] [:span.skill "mongo"]
        [:span.skill "react"] [:span.skill "sveltekit"] [:span.skill "oauth"]
        [:span.skill "olap"]]]
      [:div.photo [:iframe.tui-bg-orange-white {:src "assets/me.html"}]]]
     [:section.summary.tui-window
      [:fieldset.tui-fieldset [:legend "Summary"]
       [:p.description
        "Full-stack engineer with over 13 years of experience building developer platforms, cloud infrastructure, and AI-integrated software, with a focus on product growth. Works across system design and hands-on implementation, owning features end-to-end from frontend to infrastructure and taking products from MVP to production."]]]
     [:section.job-exp.tui-window
      [:fieldset.tui-fieldset [:legend "Job experience"] [:p.timeline-now "Now"]
       (job "ArchetypeAI" "Software engineer" "Dec 2025"
        [:div.job-description "Senior Full-Stack engineer"]
        [:ul.job-notable
         [:li "Took over the platform console as an unstructured prototype and brought it to production: refactored the codebase, expanded test coverage, set up CI pipelines, and fixed the known bugs"]
         [:li "Prepared the codebase for AI-assisted development: wrote CLAUDE.md agent instructions and reusable skills, and added the test suite to CI as a check on agent-written code"]
         [:li "Set up a design-to-engineering workflow where designers either hand over coded throwaway prototypes as input for new features or build features with Claude Code and open pull requests for review"]])
       (job "Neon (acquired by Databricks)" "Software engineer" "Jun 2022"
        [:p.job-description "Fullstack developer"]
        [:ul.job-notable
         [:li "Built the Hasura integration after Heroku sunset its free Postgres tier, making Neon Hasura's default database provider; daily signups grew 4x (about 30 to 120 per day)"]
         [:li "Designed and built Neon's OAuth provider on ORY Hydra and extended the public API for partner provisioning; it became the model for later integrations with Vercel, Replit, and Retool"]
         [:li "Created neonctl, Neon's official CLI, and led it as top contributor (about 200 commits, 360+ releases); it now sees 2M+ npm downloads a month"]
         [:li "Developed, coordinated and pushed growth initiatives, such as a credits system"]
         [:li "Introduced the first TypeScript microservice in the stack"]
         [:li "Introduced the first AI features into the console"]
         [:li "Interviewed about 50 engineering candidates and hired around 5; the early hires became foundational to the company's growth"]])
       (job "Cube.dev" "Software engineer" "Oct 2021"
        [:p.job-description "Cloud infrastructure developer"]
        [:ul.job-notable
         [:li "Implemented alerting system pipeline from scratch"]
         [:li "Improved several UI and infrastructure features"]])
       (job "Yandex" "Frontend dev" "Apr 2018"
        [:p.job-description
         "Alice (intelligent voice assistant) infrastructure developer"]
        [:ul.job-notable
         [:li
          "Implemented backend rendering process for assistant visual responses as a microservice unit"]
         [:li "Improved platform for external developers"]
         [:li "Mentored and guided a trainee"]]
        [:p.job-description "Analytical tracking system developer"]
        [:ul.job-notable
         [:li
          "Introduced redux, redux-saga, react and typescript into project from scratch"]
         [:li "Developed applicative library for redux"]
         [:li
          "Gave series of lectures and masterclasses about typescript, redux, redux-saga"]])
       (job "bolt.com" "Frontend dev" "Oct 2016"
        [:p.job-description "Web developer"]
        [:ul.job-notable
         [:li "Wrote integration scripts for external ecommerce platforms"]
         [:li "Built the company's advertising website from scratch"]])
       (job "Mail.ru Group" "Frontend dev" "Aug 2015"
        [:p.job-description "Developed web app for analytical tracking system"]
        [:ul.job-notable
         [:li
          "Wrote a map-based report from scratch (including retrieving raw map data and converting it to web format)"]
         [:li "Worked on a large advertising platform in a team of 8"]])
       (job "Undev" "Frontend ninja" "Dec 2013"
        [:p.job-description "Developed various frontends"]
        [:ul.job-notable
         [:li
          "Wrote frontend for a live video broadcast service of state elections and examinations"]
         [:li
          "Optimized and refactored module for producing clustered geo data"]
         [:li "Wrote game app and media transmit protocol for Smart TV"]])]]
     [:section.edu.tui-window
      [:fieldset.tui-fieldset [:legend "Education"]
       [:p.description
        "MSU, Faculty of Computational Mathematics and Cybernetics with master’s degree in “Applied Mathematics and Computer Science”, 2007 &mdash; 2013"]]]
     [:section.links (link "mailto:bird.duskpoet@gmail.com" "Email")
      [:span.skip-print (link "https://habr.com/ru/post/522864" "Habr")]
      (link "https://github.com/duskpoet" "Github")
      (link "https://www.linkedin.com/in/eduard-dykman-2ba890aa/" "LinkedIn")
      [:span.skip-print (link "blog.html" "Blog")]]]]))
