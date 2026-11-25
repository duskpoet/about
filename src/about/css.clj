(ns about.css
  (:require [garden.core :as garden]
            [garden.stylesheet :refer [at-media]]))

(defn css
  []
  (garden/css
    [:body :html {:height "100%", :width "100%"}]
    [:p {:margin 0}]
    [:div.content
     {:padding "50px",
      :width "100%",
      :min-height "100%",
      :display "flex",
      :flex-direction "column",
      :align-items "center",
      :justify-content "flex-start"}]
    [:section {:max-width "860px", :margin-top "40px"}]
    [:section.about-me
     {:display "flex",
      :justify-content "flex-start",
      :align-items "flex-start",
      :text-align "left",
      :margin-top "0",
      :padding "20px"} [:>* {:line-height "28px", :vertical-align "top"}]
     [:span.value {:margin-left "12px"}]]
    [:div.photo {:margin-left "20px"}]
    [:iframe {:border 0, :width "322px", :height "368px"}]
    [:span.skills {:display "inline"}]
    [:span.skill
     {:background "#00a8a8",
      :display "inline-block",
      :padding "2px 4px",
      :margin-left "12px",
      :margin-top "12px",
      :line-height "24px",
      :position "relative"}
     [:span.skill-js
      {:display "none",
       :position "absolute",
       :top 0,
       :left 0,
       :line-height "28px",
       :color "#ffff00",
       :padding-left "4px",
       :background "#00a8a8"}] [:&:hover>.skill-js {:display "inline-block"}]]
    ;; Timeline: the fieldset's left border is the line; "Now" and each job's
    ;; start year are ticks branching off it. The -12px margin cancels the
    ;; tui-fieldset padding so ticks touch the border.
    [:.timeline-now :.job-since
     {:position "relative",
      :display "flex",
      :align-items "center",
      :margin-left "-12px",
      :padding-left "22px",
      :line-height "20px",
      :text-align "left",
      :font-weight "bold"}
     [:&:before
      {:content "''",
       :position "absolute",
       :left 0,
       :top "9px",
       :width "16px",
       :height "2px",
       :background "#ffffff"}]]
    [:.job {:text-align "left"}
     ["&:not(:last-of-type)"
      [:.job-since:after
       {:content "''",
        :flex "1 1 auto",
        :height "1px",
        :margin-left "12px",
        :background "#ffffff"}]]]
    [:.job-body {:padding "8px 0 10px"}]
    [:.job-since {:color "#ffd27c"}
     [:time {:cursor "default"}
      [:.since-month {:display "none"}]
      [:&:hover [:.since-month {:display "inline"}]]]]
    [:.title {:font-size "20px", :font-weight "bold"}]
    [:.job-title {:font-size "16px"}]
    [:.job-description {:margin-top "16px"}]
    [:ul.job-notable {:margin-top "8px", :color "#ffd27c"}
     [:&:before {:content "'Notable projects: '", :font-weight "bold"}]
     [:li {:list-style-type "circle", :margin-left "20px"}]]
    [:.links [:a {:margin-left "24px"} [:.link-href {:display "none"}]]]
    [:.edu :.summary {:text-align "left"}]
    [:.bg-article {:background "#d2ffff"}]
    [:.article {:color "#1f1f1f", :line-height "26px", :padding "40px 0"}
     [:h1 {:font-size "24px"}] [:a {:color "#0000A8"}]
     [:pre
      {:background "#eaf5ee",
       :padding "10px",
       :border-radius "4px",
       :border "1px solid #ccc",
       :white-space "break-spaces"}]
     [:img {:max-width "100%", :margin "16px 0"}]]
    (at-media {:max-width "800px"}
              [:body {:font-size "14px"}]
              [:div.content {:padding "20px"}]
              [:section {:width "100%"}]
              [:div.photo {:display "none"}]
              [:section.about-me {:padding "10px"}]
              [:.title {:font-size "16px"}]
              [:span.skill
               {:margin-left "8px", :margin-top "8px", :line-height "18px"}]
              [:.links>a {:margin-left "8px"}]
              [:section {:margin-top "20px"}])
    (at-media {:print true}
              [:* {:color "#000 !important"}]
              [:.skip-print {:display "none"}]
              [:body {:font-size "12px"}]
              [:.tui-window {:box-shadow "none"}]
              [:.tui-button {:box-shadow "none"}]
              [:legend {:font-size "1.5em", :font-weight "bold"}]
              [:div.content {:padding 0}]
              [:.links {:text-align "left"}
               [:&>a [:.tui-button:after {:content "'    '"}]
                [:.link-href {:display "initial"}]
                [:&:after {:content "'\\a'", :white-space "pre"}]]]
              [:.link-pads {:white-space "pre"}]
              [:.job-since:before :.job-since:after :.timeline-now:before
               {:background "#000 !important",
                :-webkit-print-color-adjust "exact",
                :print-color-adjust "exact"}]
              [:.since-month {:display "inline !important"}]
              [:.job-exp>.tui-fieldset {:border-left-color "#000"}]
              [:nav.tui-nav {:display "none"}])))



