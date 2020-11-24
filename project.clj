(defproject about "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [hiccup "1.0.5"]
                 [clojure.java-time "0.3.2"]
                 [garden "1.3.10"]]
  :main about.core
  :repl-options {:init-ns about.core}
  :repl {:plugins [[cider/cider-nrepl "0.25.2"]]})
