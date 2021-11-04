(defn youtube [id]
  [video {:box :lg
          :controls true
          :url (format "https://www.youtube.com/watch?v=%s" id)}])

(def videos
  {:sniffer-repl "HxejHqw4jfI"
   :notebook "8TwXaVTZ1G8"
   :clojisr "BbjYkDmp3fg"})

(defn show-video [[name id]]
  [:div
   [:h1.text-xl.text-blue-900 name]
   [youtube id]])
(defn video-list [name list]
  ^:R  ; this is needed, soartefacts function can be used in the repl
  [:div
   [:h1.text-3xl.text-blue-900 name]
   (into [:div]
         (map show-video list))])

(defn about-page [{:keys [route-params query-params handler] :as route}]
  [:div.bg-green-100.h-screen
   [link-href "/" "goto main page"]
   [:h1.text-3xl.text-blue-900.mb-5.mt-5 "Goldly"]
   [video-list "unsorted videos" videos]])

(add-page about-page :user/about)