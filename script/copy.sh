#!/bin/sh


echo "copying static site"
cp -r ./target/static/*.html ./docs
cp -r ./target/static/r/config.edn ./docs/r/config.edn

cp -r ./target/res/public ./docs/r

cp -r ./target/webly/public ./docs/r


