# demo - goldly

This is a demo that shows how to use goldly with tools.deps or leiningen.

You would want to use *either* tools.deps *or* leiningen.
We have included both so you can choose.
We recommend tools.deps (because it has less dependency resolution problems).

To be very clear: tools.deps is the way to go. 

## Run Demo (goldly docs)

First, clone this repo.

- with tools.deps: `clojure -X:goldly-docs`
- with leiningen: `lein goldly-docs`

After starting, open web-browser on port 8000.

## Run Demo (custom cljs build)

You only need to build a custom cljs build:
- if you want to use ui-components that are not included in goldly-docs.
- if you want you want to compile your own clojurescript code.
  (this could be relevant if you need say core.async which is not available in 
  sci interpreted clojurescript)

For this demo, it is not neccesary to build cljs. But lets do it for fun anyhow.

The following commands will build a bundel, and recompile it in case a source file
changes. Shadow-cljs calls this "watch".

- with tools.deps: `clojure -X:goldly`
- with leiningen: `lein goldly`

You can use *"watch"* which brings 10x developer tools.
Or you can use *"watch2"* which does not. 10x developer tools make the bundel bigger,
but could be helpful for debugging.

## Run Demo (custom bundel - build & run)

This involves two steps:
- *compiling* a javascript bundel (output is in target/webly/public)
- *running* a web server and serving the page/bundel. 
  After you compiled the bundel you can run it multiple times.  

with tools.deps: `./scripts/compile_adv_run.sh`

with leiningen:
```
lein npm-install
lein build-release
lein jetty
```
