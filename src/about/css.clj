(ns about.css
  (:require [garden.core :as garden]))

(defn css []
  (garden/css
    [:body :html {:height "100%" :width "100%"}]
    [:div.content
      {:padding "50px"
       :width "100%"
       :display "grid"
       :grid-template "auto / 800px"
       :justify-content "center"
       :grid-row-gap "50px"}]
    [:section {:max-width "1000px"}]
    [:section.about-me
      {:display "grid"
       :grid-template "auto / 400px auto"
       :text-align "left"
       :padding "20px"}
      [:>* {:line-height "28px" :vertical-align "top"}]
      [:span.value {:margin-left "12px"}]]
    [:iframe {:border 0 :width "322px" :height "368px"}]
    [:span.skills
     {:display "inline"}]
    [:span.skill
      {:background "#00a8a8"
       :display "inline-block"
       :padding "2px 4px"
       :margin-left "12px"
       :margin-top "12px"
       :line-height "24px"
       :position "relative"}
      [:span.skill-js
       {:display "none"
        :position "absolute"
        :top 0
        :left 0
        :line-height "28px"
        :color "#ffff00"
        :padding-left "4px"
        :background "#00a8a8"}]
      [:&:hover>.skill-js {:display "inline-block"}]]
    [:.job
     {:text-align "left"}
     ["&:not(:last-of-type)"
      {:border-bottom "1px solid #ffffff"}
      {:margin-bottom "10px"}]]
    [:.place
     {:font-size "20px"
      :font-weight "bold"}]
    [:.job-title
     {:font-size "16px"}]
    [:.job-description {:margin-top "10px"}]
    [:.job-notable
     {:margin-top "10px"
      :color "#ffd27c"}
     [:&:before
        {:content "'Notable projects: '"
         :font-weight "bold"}]]
    [:.links>a
      {:margin-left "24px"}]))
