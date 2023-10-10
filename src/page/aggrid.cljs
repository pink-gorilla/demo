(ns page.aggrid
  (:require
   [tick.core]
   [ui.aggrid :refer [aggrid]]
   [goldly.page]
   [lib.ui :refer [wrap-page-site link-dispatch]]))

(def data
  (map (fn [i] {:idx i
                :name "jon"
                :date (tick.core/now)
                :text "jg kj jkhj jh gk g"})
       (range 500)))

(defn aggrid-page [_route-data]
  [:div.h-screen.w-screen
   [:div {:style {:position "absolute"}}
    [link-dispatch [:bidi/goto :user/main] "main"]]
   ;[:p "data" (pr-str data)]
   [aggrid {:data data
            :box :fl
            :pagination true
            :paginationAutoPageSize true}]])

(def aggrid-page-wrapped (wrap-page-site aggrid-page))


