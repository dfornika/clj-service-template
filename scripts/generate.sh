#!/bin/bash

clojure \
    -Sdeps '{:deps {net.clojars.dfornika/clj-service {:local/root "."}}}' \
    -Tnew create \
    :template dfornika/clj-service \
    :name dfornika/generated-service \
    :target-dir ../generated-service
