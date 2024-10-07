DROP TABLE IF EXISTS digital_products CASCADE;

CREATE TABLE digital_products (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price_in_cents BIGINT NOT NULL,
    file_format VARCHAR(255) NOT NULL,
    file_size VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);