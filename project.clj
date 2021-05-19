(defproject org.pinkgorilla/goldly-bundel "0.2.34-SNAPSHOT"
  :description "goldly bundel"
  :license {:name "MIT"}
  :url "https://github.com/pink-gorilla/goldly-bundel"
  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/release_username
                                     :password :env/release_password
                                     :sign-releases false}]]
  :min-lein-version "2.9.3"
  :min-java-version "1.11"

  :release-tasks [["vcs" "assert-committed"]
                  ["bump-version" "release"]
                  ["vcs" "commit" "Release %s"]
                  ["vcs" "tag" "v" "--no-sign"]
                  ["deploy"]
                  ["bump-version"]
                  ["vcs" "commit" "Begin %s"]
                  ["vcs" "push"]]

  :source-paths ["src"]
  :resource-paths ["target/webly"] ; js bundle
  :target-path  "target/jar"
  :main  goldly-server.app ;^:skip-aot 
  ;:aot [goldly-server.app]
  ;:jar-exclusions [#"clojure.*" ; clojure is too version specific
  ;                 #"shadow.*" ; shadow cljs is only a build tool.
  ;                 #"nrepl.*"
  ;                 #"taoensso.*"]

  :dependencies [;[org.pinkgorilla/webly "0.2.38"] ; not having this crashes
                 [org.pinkgorilla/goldly "0.2.48"]
                 ; bundled dependencies
                 [org.pinkgorilla/gorilla-ui "0.3.22" :exclusions [org.clojure/clojurescript]]
                 [org.pinkgorilla/gorilla-plot "1.2.8" :exclusions [org.clojure/clojurescript]]
                 [org.pinkgorilla/ui-binaryclock "0.0.4"]
                 [org.pinkgorilla/ui-quil "0.1.5"]]

  :profiles {:dev {:plugins      [[lein-cljfmt "0.6.6"]
                                  [lein-shell "0.5.0"]
                                  [lein-ancient "0.6.15"]
                                  [min-java-version "0.1.0"]]
                   :aliases      {"bump-version"
                                  ["change" "version" "leiningen.release/bump-version"]}}}

  :aliases {"npm-install"
            ["run" "-m" "goldly-server.app" "npm-install" "goldly-bundel.edn"]

            "build-release"
            ["run" "-m" "goldly-server.app" "release" "goldly-bundel.edn"]

            "demo"
            ["run" "-m" "goldly-server.app" "watch" "goldly-bundel.edn"]})

