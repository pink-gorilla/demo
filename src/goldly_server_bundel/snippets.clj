(ns goldly-server-bundel.snippets
  (:require [systems.snippet-registry :refer [add-snippet]]))

(add-snippet {:type :goldly-clj
              :category :goldly-bundel
              :id :holiday-snippet
              :filename "snippets/goldly-bundel/holiday.clj"})

(add-snippet {:type :goldly-clj
              :category :goldly-bundel
              :id :controls-snippet
              :filename "snippets/goldly-bundel/controls.clj"})

(add-snippet {:type :goldly-clj
              :category :goldly-bundel
              :id :vega-gorilla-plot
              :filename "snippets/goldly-bundel/vega_gorilla_plot.clj"})

(add-snippet {:type :goldly-clj
              :category :goldly-bundel
              :id :vega-bar
              :filename "snippets/goldly-bundel/vega_bar.clj"})

(add-snippet {:type :pinkie
              :category :goldly-bundel
              :id :vega-multiline
              :filename "snippets/goldly-bundel/vega_multiline.edn"})

(add-snippet {:type :pinkie
              :category :goldly-bundel
              :id :vega-zoom
              :filename "snippets/goldly-bundel/vega_zoom.edn"})