(defn block [{:keys [name class]}  & children]
  (into [:div.bg-blue-400.m-5.inline-block
         {:class class}
         [:h1.text-2xl name]]
        children))

(defn svg [url-link url-img p]
  [:a {:href (format url-link p)}
   [:img.inline-block
    {:src
     (format url-img p)}]])

(defn project [p]
  [:p ; p
   [svg "https://github.com/pink-gorilla/%s/actions?workflow=CI"
    "https://github.com/pink-gorilla/%s/workflows/CI/badge.svg" p]

   [svg "https://codecov.io/gh/pink-gorilla/%s"
    "https://codecov.io/gh/pink-gorilla/%s/branch/master/graph/badge.svg" p]

   [svg "https://clojars.org/org.pinkgorilla/%s"
    "https://img.shields.io/clojars/v/org.pinkgorilla/%s.svg" p]])

(def build-tool ["webly" "goldly"])

(def goldly-extensions ["reval"
                        "ui-repl"
                        "ui-input"
                        "ui-site"
                        "ui-vega"
                        "ui-highcharts"
                        "ui-math"
                        "ui-gorilla"
                        "ui-quil"
                        "ui-leaflet"
                        "ui-cytoscape"
                        "ui-code"
                        "ui-markdown"
                        "ui-binaryclock"])

(def notebook-legacy ["picasso"
                      "pinkie"
                      "notebook"
                      "nrepl-middleware" "notebook-encoding" "gorilla-explore"
                      "kernel-cljs-shadow"])

; ^:R
(defn artefacts [name list]
  ^:R  ; this is needed, soartefacts function can be used in the repl
  [:div
   [:h1.text-3xl.text-red-400 name]
   (into [:div]
         (map project list))])

(defn artefact-page [{:keys [route-params query-params handler] :as route}]
  [:div.bg-green-100.h-screen
   [link-href "/" "goto main page"]
   [:h1.text-3xl.text-green-500.mb-5.mt-5 "PinkGorilla Clojars Artefacts"]
   [:audio {:src "/r/demo/daddys-outta-town.mp3"
            :controls false
            :auto-play true
            :loop true
            :preload "auto"}]
   [artefacts "build tools" build-tool]
   [artefacts "goldly extensions" goldly-extensions]
   [artefacts "notebook (legacy)" notebook-legacy]])

(add-page artefact-page :user/artefact)