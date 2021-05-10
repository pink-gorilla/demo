# goldly bundel

Goldly bundel clojars dependency ships the compiled js bundle 
The bundel contains:
- goldly
- gorilla-ui
- gorilla-plot


# Run Demo

```
lein demo
```

Then open web-browser on port 8000.

# dev notes

- this project exists to ship the compiled js bundle
- it cannot be included in goldly itself, because goldly is a library
  that is consumed in notebook (which buids its own bundel)
  