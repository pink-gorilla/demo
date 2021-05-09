(ns goldly-server.bundled
  (:require
   [webly.config :refer [add-config]]
   [goldly-server.app :as goldly])
  (:gen-class))

(defn goldly-server-build! []
  (goldly/goldly-server-run! "goldly-bundeled.edn" "release"))

(defn goldly-server-run!
  ([]
   (goldly-server-run! nil "jetty"))
  ([user-config]
   (goldly-server-run! user-config "jetty"))
  ([user-config profile]
   (let [config (add-config "goldly-bundeled.edn" user-config)]
     (goldly/goldly-server-run! config profile))))

(defn -main
  ([]
   (goldly-server-run! nil))
  ([user-config]
   (goldly-server-run! user-config)))