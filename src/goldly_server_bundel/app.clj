(ns goldly-server-bundel.app
  (:require
   [taoensso.timbre :as timbre :refer [info warn]]
   [webly.config :refer [load-config! add-config get-in-config]]
   [webly.user.app.app :refer [webly-run!]]
   [webly.profile :refer [server?]]
   [goldly.app :refer [goldly-run!]]
   [goldly-server.routes]
   [goldly-server-bundel.snippets]; side-effects
   )
  (:gen-class))

(defn run-goldly! []
  (let [goldly-enabled (get-in-config [:goldly :enabled])]
    (if goldly-enabled
      (goldly-run!)
      (warn "goldly is disabed!"))))

(defn goldly-server-run!
  [{:keys [config profile] ; a map so it can be consumed by tools deps -X
    :or {profile "jetty"
         config {}}}]
  (let [config (add-config "goldly-bundel.edn" config)]
    (if (server? profile)
      (do (load-config! config)
          (goldly-run!))
      (warn "no server mode. not running goldly"))
    (webly-run! profile config)))

(defn -main
  ([]
   (goldly-server-run! {}))
  ([profile]
   (goldly-server-run! {:profile profile})))