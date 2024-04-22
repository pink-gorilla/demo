;;; # How to use NPM dependencies in Shadow CLJS Kernel
;;; 
;;; The Shadow CLJS kernel uses Self Hosted Clojurescript in the Notebook Browser. 
;;; Dependencies are loaded via Bundles that are created by kernel-shadow-deps. 
;;; This bundles can contain both Clojurescript and NPM modules.
;; **


(ns unsightly-resonance
  (:require
   [fortune.core :as f]
   [module$node_modules$moment$moment :as m]))

; 2019 03 31 awb99: broken - not sure why. this used to work.
(.now m)

; 2019 03 31 awb99: broken - not sure why. this used to work.
; listing works ony when no compression used in js bundle
;(. js/shadow.js -files)

(def moment (.jsRequire js/shadow.js "module$node_modules$moment$moment"))
;(def moment (.jsRequire js/shadow.js 1))

(.now moment)


