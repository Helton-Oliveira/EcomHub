ALTER TABLE digital_products
ADD COLUMN active BOOLEAN;

UPDATE digital_products
SET active = TRUE
WHERE active IS NULL;