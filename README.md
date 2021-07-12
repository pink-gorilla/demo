# demo - goldly

This is a demo that shows how to build a custom goldly app
with tools.deps or leiningen.

You would want to use *either* tools.deps *or* leiningen.
We have included both so you can choose.
We recommend tools.deps (because it has less dependency resolution problems).

First, clone this repo.
After starting, open web-browser on port 8000.


## Run Demo (prebuilt bundel)

This is all you need!

- with tools deps: `clojure -X:goldlyb`
- with leiningen: `lein goldlyb`

## Run Demo (custom bundel - watch)

Normally there is no need for this!

- with tools deps: `clojure -X:goldly`
- with leiningen: `lein goldly`

## Run Demo (custom bundel - build & run)

with leiningen:
```
lein npm-install
lein build-release
lein jetty
```

with tools.deps: `./scripts/compile_adv_run.sh`
