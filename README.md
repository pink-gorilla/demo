# demo 

The demo app has this features:
- bmi: complex ui interaction
- fortune cookies: demonstrates how to load data from clojure (could be a database)
- time: demonstrates to push data from clojure
- iss: international space stations current position


## demo running goldly-docs

First, clone this repo. Then run:
 ```
 clojure -X:nb-eval
 clojure -X:webly:run
 ```
After starting, open web-browser on port 8080.

## github pages

The demo is also on [Github Pages](https://pink-gorilla.github.io/demo/)


## demo with custom dynamic cljs build

You only need to build a custom cljs build:
- if you want to use ui-components that are not included in goldly-docs.
- if you want you want to compile your own clojurescript code.

For this demo, it is not neccesary to build cljs. But lets do it for fun anyhow.

The following commands will build a js bundel:

``` 
  clojure -X:webly:npm-install
  clojure -X:webly:compile
  clojure -X:webly:run
```
