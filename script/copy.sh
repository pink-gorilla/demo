#!/bin/sh


echo "copying static site"
rm -r ./docs
mkdir ./docs


cp -r ./target/res/public ./docs
cp -r ./target/webly/public ./docs

cp -r ./target/static/*.html ./docs
cp -r ./target/static/r/config.edn ./docs/public/config.edn

mv ./docs/public ./docs/r
#mkdir ./docs/r
# mv ./docs/public ./docs/r


cp -r src/lib ./docs/r/lib
cp -r src/page ./docs/r/page



cp -r ./target/sci/ ./docs/


cp -r ./docs/sci/lib ./docs/r/
cp -r ./docs/sci/goldly ./docs/r/
cp -r ./docs/sci/page ./docs/r/

