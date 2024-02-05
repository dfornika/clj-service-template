#!/bin/bash

psql -U postgres -e ""

psql -U postgres - <<EOF
\copy DROP DATABASE IF EXISTS "dev";
CREATE DATABASE "dev";
\c "dev";
GRANT ALL PRIVILEGES ON DATABASE "dev" TO "dev";
GRANT ALL PRIVILEGES IN SCHEMA public TO "dev";
EOF
