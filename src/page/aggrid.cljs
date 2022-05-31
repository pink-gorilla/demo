(ns page.aggrid
  (:require
   [tick.core]
   [ui.aggrid :refer [aggrid]]
   [goldly.page]
   [lib.ui :refer [add-page-site link-dispatch]]))

(def data
  (map (fn [i] {:idx i
                :name "jon"
                :date (tick.core/now)
                :text "jg kj jkhj jh gk g"})
       (range 500)))

(defn aggrid-page [{:keys [route-params query-params handler] :as route}]
  [:div.h-screen.w-screen
   [:div {:style {:position "absolute"}}
    [link-dispatch [:bidi/goto :user/main] "main"]]
   ;[:p "data" (pr-str data)]
   [aggrid {:data data
            :box :fl
            :pagination true
            :paginationAutoPageSize true}]])

(add-page-site aggrid-page :user/aggrid)
