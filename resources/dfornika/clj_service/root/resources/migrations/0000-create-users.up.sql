CREATE TABLE "users" (
    pk SERIAL PRIMARY KEY,
    user_id TEXT NOT NULL,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp
);
