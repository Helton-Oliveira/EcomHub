DROP TABLE IF EXISTS physical_products CASCADE;

CREATE TABLE physical_products (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price_in_cents BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    category VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL
);