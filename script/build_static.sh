#!/bin/sh

echo "building static github page"

clojure -X:goldly-docs :profile '"npm-install"'
clojure -X:goldly-docs :profile '"static"'

clojure -X:nbeval

./script/copy.sh