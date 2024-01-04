(ns user
  (:require [integrant.repl]))

(def prep integrant.repl/prep)
(def init integrant.repl/init)
(def go integrant.repl/go)
(def halt integrant.repl/halt)
(def reset integrant.repl/reset)
(def reset-all integrant.repl/reset-all)

(def config-path "dev-config.edn")

(comment
  (go)
  (reset)
  (halt)
  )
