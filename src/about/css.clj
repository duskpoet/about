(ns about.css
  (:require [garden.core :as garden]
            [garden.stylesheet :refer [at-media]]))

(defn css []
  (garden/css
   [:body :html {:height "100%" :width "100%"}]
   [:p {:margin 0}]
   [:div.content
    {:padding "50px"
     :width "100%"
     :display "flex"
     :flex-direction "column"
     :align-items "center"
     :justify-content "flex-start"}]
   [:section {:max-width "860px" :margin-top "40px"}]
   [:section.about-me
    {:display "flex"
     :justify-content "flex-start"
     :align-items "flex-start"
     :text-align "left"
     :margin-top "0"
     :padding "20px"}
    [:>* {:line-height "28px" :vertical-align "top"}]
    [:span.value {:margin-left "12px"}]]
   [:div.photo {:margin-left "20px"}]
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
     {:margin-bottom "20px"}
     {:padding-bottom "10px"}]]
   [:.title
    {:font-size "20px"
     :font-weight "bold"}]
   [:.job-title
    {:font-size "16px"}]
   [:.job-description {:margin-top "16px"}]
   [:ul.job-notable
    {:margin-top "8px"
     :color "#ffd27c"}
    [:&:before
     {:content "'Notable projects: '"
      :font-weight "bold"}]
    [:li
     {:list-style-type "circle"
      :margin-left "20px"}]]
   [:.links>a
    {:margin-left "24px"}
    [:.link-href
     {:display "none"}]]

   [:.edu {:text-align "left"}]

   (at-media {:max-width "800px"}
    [:body {:font-size "14px"}]
    [:div.content {:padding "20px"}]
    [:section {:width "100%"}]
    [:div.photo {:display "none"}]
    [:section.about-me {:padding "10px"}]
    [:.title {:font-size "16px"}]
    [:span.skill
      {:margin-left "8px"
       :margin-top "8px"
       :line-height "18px"}]
    [:.links>a {:margin-left "8px"}]
    [:section {:margin-top "20px"}])

   (at-media {:print true}
    [:* {:color "#000 !important"}]
    [:.tui-window {:box-shadow "none"}]
    [:.tui-button {:box-shadow "none"}]
    [:legend {:font-size "1.5em" :font-weight "bold"}]
    [:div.content {:padding 0}]
    [:.links
     {:text-align "left"}
     [:&>a
      [:.tui-button:after {:content "'    '"}]
      [:.link-href {:display "initial"}]
      [:&:after {:content "'\\a'" :white-space "pre"}]
      ["&[href^=\"https://habr.com\"]" {:display "none"}]]]
    [:.link-pads {:white-space "pre"}]
    [:div.job 
      ["&:not(:last-of-type)"
       {:border-bottom "1px solid #ccc"}]])))

    