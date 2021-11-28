#!/bin/sh

echo "building static github page"

clojure -X:goldly-docs :profile '"npm-install"'
# clojure -X:goldly :profile '"release-adv"'
clojure -X:goldly-docs :profile '"static"'

clojure -X:nbeval

./script/copy.sh