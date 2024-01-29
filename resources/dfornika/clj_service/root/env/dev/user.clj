(ns user
  (:require [integrant.repl :refer [clear go halt prep init reset reset-all]]
            [ragtime.repl]
            [{{top/ns}}.config]
            [{{top/ns}}.system]))

(def config-path "dev-config.edn")

(defn pref-fn
  ""
  []
  (-> {{top/ns}}.system/system-config
      (assoc-in [:app/config :path] config-path)))

(integrant.repl/set-prep! pref-fn)

(comment
  (ragtime.repl/migrate config)
  (go)
  (reset)
  (halt)
  )
