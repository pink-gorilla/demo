(defproject org.pinkgorilla/demo-goldly "0.0.2"
  :description "goldly demo"
  :license {:name "MIT"}
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

  :managed-dependencies [[org.clojure/core.async "1.3.610"]
                         [org.clojure/tools.logging "1.1.0"]
                         [org.clojure/core.memoize "1.0.236"]
                         ; libpythonclj fixes
                         [net.java.dev.jna/jna "5.6.0"]
                         [org.ow2.asm/asm "8.0.1"]
                         [nrepl "0.8.0"]]

  :dependencies [[org.pinkgorilla/goldly "0.2.11"]
                 ; user dependencies
                 [org.pinkgorilla/gorilla-ui "0.2.28" :exclusions [org.clojure/clojurescript]]
                 [org.pinkgorilla/gorilla-plot "1.2.4" :exclusions [org.clojure/clojurescript]]
                 [org.pinkgorilla/nrepl-middleware "0.3.11"]
                 [org.pinkgorilla/notebook-ui "0.0.70"]]

  :source-paths ["src"]
  :resource-paths ["target/webly"] ; js bundle
  :target-path  "target/jar"

  :profiles {:dev {:source-paths ["test"]
                   :dependencies [[clj-kondo "2020.07.29"]]
                   :plugins      [[lein-cljfmt "0.6.6"]
                                  [lein-cloverage "1.1.2"]
                                  [lein-codox "0.10.7"]
                                  [lein-shell "0.5.0"]
                                  [lein-ancient "0.6.15"]
                                  [min-java-version "0.1.0"]
                                  [lein-resource "17.06.1"]
                                  ;[lein-environ "1.1.0"] ;; TODO Will likely be axed soon
                                  ]
                   :aliases      {"lint" ^{:doc "Runs code linter"}
                                  ["run" "-m" "clj-kondo.main" "--lint" "src"]

                                  "bump-version"
                                  ["change" "version" "leiningen.release/bump-version"]}

                   :aot []
                   :cloverage    {:codecov? true
                                  ;; In case we want to exclude stuff
                                  ;; :ns-exclude-regex [#".*util.instrument"]
                                  ;; :test-ns-regex [#"^((?!debug-integration-test).)*$$"]
                                  }
                   ;; TODO : Make cljfmt really nice : https://devhub.io/repos/bbatsov-cljfmt
                   :cljfmt       {:indents {as->                [[:inner 0]]
                                            with-debug-bindings [[:inner 0]]
                                            merge-meta          [[:inner 0]]
                                            try-if-let          [[:block 1]]}}}}


  :aliases {; shadow-compile is only needed to update package.json with transitive dependencies
            "shadow-compile"
            ["with-profile" "+dev" "run" "-m" "shadow.cljs.devtools.cli" "compile" ":webly"]

             ;; APP

            "build-dev"  ^{:doc "compiles bundle-dev"}
            ["with-profile" "+dev" "run" "-m" "webly.build-cli" "compile" "+dev" "goldly.app/handler" "demo.app"]

            "build-prod"  ^{:doc "compiles bundle-prod"}
            ["with-profile" "+dev" "run" "-m" "webly.build-cli" "release" "+dev" "goldly.app/handler" "demo.app"]

            "goldly"  ^{:doc "runs compiled bundle on shadow dev server"}
            ["with-profile" "+dev" "run" "-m" "goldly.app"  "src/systems/"]})

