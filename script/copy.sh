#!/bin/sh


echo "copying static site"
cp -r ./target/static/*.html ./docs
cp -r ./target/static/*.edn ./docs

cp -r ./target/res/public ./docs/r

