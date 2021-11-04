(defproject demo/goldly-demo "0.0.1-SNAPSHOT"
  :description "goldly demo"
  :license {:name "MIT"}
  :min-lein-version "2.9.3"
  :min-java-version "1.11"

  :source-paths ["src"]
  :resource-paths ["target/webly"] ; js bundle
  :target-path  "target/jar"

  :dependencies [[org.clojure/clojure  "1.10.3"]]

  :managed-dependencies [; conflict resolution
                         ; this is not needed in tools.deps
                         [borkdude/sci "0.2.6"]
                         [com.fasterxml.jackson.core/jackson-core "2.12.4"]
                         [cljs-ajax "0.8.3"]]

  :profiles
  {:docs {:dependencies
            [; no ui extension dependencies needed in goldly-docs
             [org.pinkgorilla/goldly-docs "0.3.68"]]}
   :custom {:dependencies
            [[org.pinkgorilla/goldly "0.3.68"]
             [org.pinkgorilla/ui-input "0.0.13"]
             [org.pinkgorilla/ui-aggrid "0.0.11"]
             [org.pinkgorilla/ui-leaflet "0.0.10"]
             [org.pinkgorilla/ui-vega "0.0.23"]
             [org.pinkgorilla/ui-gorilla "0.3.50"]
             [org.pinkgorilla/ui-binaryclock "0.0.12"]]}}

  :aliases
  {; goldly-docs is all you need
   ; uses pre-built bundel
   "goldly-docs"
   ["with-profile" "+docs"
    "run" "-m" "goldly.app" "goldly-demo.edn" "jetty"]

   ; build your custom bundel

   "goldly"
   ["with-profile" "+custom"
    "run" "-m" "goldly.app" "goldly-demo.edn" "watch2"]

   "npm-install"
   ["with-profile" "+custom"
    "run" "-m" "goldly.app" "goldly-demo.edn" "npm-install"]

   "build-release"
   ["with-profile" "+custom"
    "run" "-m" "goldly.app" "goldly-demo.edn" "release"]

   "jetty"
   ["with-profile" "+custom"
    "run" "-m" "goldly.app" "goldly-demo.edn" "jetty"]})

