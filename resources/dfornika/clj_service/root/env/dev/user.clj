(ns user
  (:require [integrant.repl :refer [clear go halt prep init reset reset-all]]
            [integrant.repl.state :refer [system config]]
            [ragtime.repl]
            [ragtime.jdbc]
            [{{top/ns}}.config]
            [{{top/ns}}.system]))


(defn make-pref-fn
  ""
  [config-path]
  (fn []
    (-> {{top/ns}}.system/system-config
        (assoc-in [:app/config :path] config-path))))


(comment
  ;; DB Migrations
  (def ragtime-config {:datastore (ragtime.jdbc/sql-database
                                   {:connection-uri "jdbc:postgresql://localhost:5432/appdb"
                                    :user "appuser"
                                    :password "secret"})
                       :migrations (ragtime.jdbc/load-resources "migrations")})
  (ragtime.repl/migrate ragtime-config)
  )

(comment

  (def config-path "dev-config.edn")
  ;; App config & startup
  (integrant.repl/set-prep! (make-pref-fn config-path))
  
  (go)
  (reset)
  (halt)
  )
