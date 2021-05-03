(ns systems.bundled.controls
  (:require
   [goldly.runner :refer [system-start!]]
   [goldly.system :as goldly]))

(system-start!
 (goldly/system
  {:id :controls
   :state {:language "CommonLisp"}
   :html  [:div
           [:p "Favorite Language: " (:language @state)]
           [:p/pselectm ["Clojure" "Clojurescript" "Schema" "CommonLisp" "Elixir"] state :language]

           [:h2 "popover"]
           [:p/popover {:color "green"
                        :placement "right"
                        :button-text "trees-r"}
            [:p/tooltip {:color "green"
                         :title  "tree"
                         :content "How many trees are in a forest?"}]]
            ]
   :fns {:incr (fn [_ s] (inc s))}}
  {:fns {}}))
