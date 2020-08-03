(ns demo.app
  (:require
   [taoensso.timbre :as timbre :refer-macros [tracef debugf infof warnf errorf info]]
   [webly.config :refer [webly-config]]
   [goldly.app]
   ;[goldly.web.routes :refer [goldly-routes-backend]]

   [pinkie.default-setup] ; side-effecs pinkie
   [picasso.default-config] ; side-efects picasso
   [pinkgorilla.ui.default-renderer] ; side-effects gorilla-ui 
   [pinkgorilla.notebook-ui.default-config] ; side-effects
    ;[pinkgorilla.ui.gorilla-plot.pinkie] ; side-effects gorilla-plot TODO: update to pinkie v2
   ))

(defn ^:export start []
  (swap! webly-config assoc :timbre-loglevel :info)
  (goldly.app/start))

;(start)