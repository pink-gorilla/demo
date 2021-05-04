(defproject org.pinkgorilla/goldly-server "0.2.27"
  :description "goldly server"
  :license {:name "MIT"}
  :url "https://github.com/pink-gorilla/goldly-server"
  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/release_username
                                     :password :env/release_password
                                     :sign-releases false}]]
  :min-lein-version "2.9.3"
  :min-java-version "1.11"

  :prep-tasks ["compile"  ; aot compilation, creates .class files
               ]

  :release-tasks [["vcs" "assert-committed"]
                  ["bump-version" "release"]
                  ["vcs" "commit" "Release %s"]
                  ["vcs" "tag" "v" "--no-sign"]
                  ["deploy"]
                  ["bump-version"]
                  ["vcs" "commit" "Begin %s"]
                  ["vcs" "push"]]

  :source-paths ["src"]
  :resource-paths ["resources"  ; included data
                   "target/webly"] ; js bundle
  :target-path  "target/jar"
  :main  goldly-server.app ;^:skip-aot 
  :aot [goldly-server.app]
  :jar-exclusions [#"clojure.*" ; clojure is too version specific
                   #"shadow.*" ; shadow cljs is only a build tool.
                   #"nrepl.*"
                   #"taoensso.*"
                   ]

  :dependencies [[org.pinkgorilla/goldly "0.2.25"]
                 ; bundled dependencies
                 [org.pinkgorilla/gorilla-ui "0.3.18" :exclusions [org.clojure/clojurescript]]
                 [org.pinkgorilla/gorilla-plot "1.2.6" :exclusions [org.clojure/clojurescript]]]

  :profiles {:dev {:plugins      [[lein-cljfmt "0.6.6"]
                                  [lein-shell "0.5.0"]
                                  [lein-ancient "0.6.15"]
                                  [min-java-version "0.1.0"]]
                   :aliases      {"bump-version"
                                  ["change" "version" "leiningen.release/bump-version"]}}}

  :aliases {"npm-install"
            ["run" "-m" "goldly-server.app" "npm-install"]
            
            "build-release"
            ["run" "-m" "goldly-server.app" "release"]

            "demo"
            ["run" "-m" "goldly-server.app" "watch"]})

