(ns user
  (:require [integrant.repl :refer [clear go halt prep init reset reset-all]]
            [integrant.repl.state :refer [system config]]
            [ragtime.repl]
            [ragtime.jdbc]
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
  (def ragtime-config {:datastore (ragtime.jdbc/sql-database
                                   {:connection-uri "jdbc:postgresql://localhost:5432/dev"
                                    :user "dev"
                                    :password "dev"})
                       :migrations (ragtime.jdbc/load-resources "migrations")})
  (ragtime.repl/migrate ragtime-config)
  (go)
  (reset)
  (halt)
  )
