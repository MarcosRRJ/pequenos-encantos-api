CREATE TABLE suppliers (
    id UUID PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    whatsapp VARCHAR(30),
    city VARCHAR(80),
    state VARCHAR(2),
    average_ship_days INTEGER,
    ships_to_customer BOOLEAN NOT NULL DEFAULT TRUE,
    accepts_exchange BOOLEAN NOT NULL DEFAULT FALSE,
    defect_policy TEXT,
    notes TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
