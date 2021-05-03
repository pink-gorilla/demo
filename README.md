# goldly-server

- Goldly-server is used to bundle goldly
- gorilla-ui and gorilla-plot are included
- the clojars dependency ships the compiled js bundle


# Run Demo

```
lein demo
```

Then open web-browser on port 8000.

# dev notes

- this project exists to ship the compiled js bundle
- it cannot be included in goldly itself, because goldly is a library
  thatis consumed in notebook (whic buids its own bundle)
  