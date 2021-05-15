(ns goldly-server-bundel.app
  (:require
   [taoensso.timbre :as timbre :refer [info]]
   [re-frame.core :as rf]
   [goldly-server.app]
   ; bundled dependencies
   [pinkgorilla.ui.default-renderer]
   [pinkgorilla.ui.css :as css]
   [pinkgorilla.gorilla-plot.pinkie]

;  
   ))

(defn ^:export start []
  (goldly-server.app/start))

(rf/reg-event-db
 :goldly-server-bundel/init
 (fn [db [_ dispatch-init-done]]
   (let [db (or db {})
         {:keys [nrepl-endpoint]} (:config db)]
     (info "goldly-server-bundled/init")

     ; from gorilla-ui
     (rf/dispatch [:css/add-components css/components css/config])

     ; goldly
     (rf/dispatch [:goldly/init])

     (rf/dispatch [:webly/status :running]))))
