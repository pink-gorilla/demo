# demo - goldly

## demo running goldly-docs

First, clone this repo. Then run: `clojure -X:docs`
After starting, open web-browser on port 8080.

We demonstrate certain features of goldly:
- bmi: complex ui interaction
- fortune cookies: demonstrates how to load data from clojure (could be a database)
- time: demonstrates to push data from clojure
- iss: international space stations current position

To re-evaluate all notebooks run: `clojure -X:nbeval`

## demo with custom dynamic cljs build

You only need to build a custom cljs build:
- if you want to use ui-components that are not included in goldly-docs.
- if you want you want to compile your own clojurescript code.
  (this could be relevant if you need say core.async which is not available in 
  sci interpreted clojurescript)

For this demo, it is not neccesary to build cljs. But lets do it for fun anyhow.

The following commands will build a js bundel:

``` 
  clojure -X:docs:build :profile '"npm-install"'
  clojure -X:docs:build :profile '"compile2"'
  clojure -X:docs
```
