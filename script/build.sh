#!/bin/sh

clojure -X:goldly :profile '"npm-install"'
clojure -X:goldly :profile '"release-adv"'
clojure -X:nbeval

./script/copy.sh