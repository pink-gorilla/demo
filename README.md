# goldly bundel

Goldly bundel clojars dependency ships the compiled js bundle 
The bundel contains:
- goldly
- gorilla-ui
- gorilla-plot


# Run Demo

```
lein demo watch
```

Then open web-browser on port 8000.

## in your project (as a library)

The easiest way to run releases locally is leveraging the `clojure` cli
```
clojure -Sdeps '{:deps {org.pinkgorilla/goldly-bundel {:mvn/version "0.2.35"}}}' -m goldly-server-bundel.app
```

# dev notes

- this project exists to ship the compiled js bundle
- it cannot be included in goldly itself, because goldly is a library
  that is consumed in notebook (which builds its own bundel)
  