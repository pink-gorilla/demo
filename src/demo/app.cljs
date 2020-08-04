(ns demo.app
  (:require
   [taoensso.timbre :as timbre :refer-macros [tracef debugf infof warnf errorf info]]
   [webly.config :refer [webly-config]]
   [goldly.app]
   ;[goldly.web.routes :refer [goldly-routes-backend]]

   ; user dependencies
   [pinkie.default-setup] ; side-effecs
   [pinkgorilla.ui.default-renderer] ; side-effects 
   [pinkgorilla.gorilla-plot.pinkie] ; side-effects
   [picasso.default-config] ; side-effects 
   [pinkgorilla.notebook-ui.default-config] ; side-effects
   ))

(defn ^:export start []
  (swap! webly-config assoc :timbre-loglevel :info)
  (goldly.app/start))

;(start)