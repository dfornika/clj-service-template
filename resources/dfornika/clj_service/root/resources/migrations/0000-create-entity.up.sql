CREATE TABLE "entity" (
    id SERIAL PRIMARY KEY,
    attribute TEXT NOT NULL,
    value TEXT NOT NULL,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp
);
