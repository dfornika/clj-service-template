FROM clojure:temurin-21-tools-deps

WORKDIR /app

COPY deps.edn /app/

RUN clojure -P

COPY dev-config.edn /app/config.edn
ENV CONFIG_FILE=/app/config.edn

CMD ["clojure", "-M:dev"]