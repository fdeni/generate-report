CREATE TABLE customer(
    id int(11) NOT NULL AUTO_INCREMENT,
    email varchar(255),
    name varchar(255),
    PRIMARY KEY(id)
);

CREATE TABLE product (
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(100),
    type varchar(100),
    price int(11),
    PRIMARY KEY(id)
);

CREATE TABLE transaction (
    id int(11) NOT NULL AUTO_INCREMENT,
    product_id int(11),
    email varchar(255),
    total int(100),
    shipping_cost int(100),
    date varchar(50),
    tax int(100),
    margin int(100),
    PRIMARY KEY(id)
);

CREATE TABLE period (
    id int(11) NOT NULL AUTO_INCREMENT,
    start_date varchar(50),
    end_date varchar(50),
    margin_percentage double(11,2),
    PRIMARY KEY(id)
);

CREATE TABLE shipping (
    id int(11) NOT NULL AUTO_INCREMENT,
    cost int(100),
    PRIMARY KEY(id)
);

INSERT INTO product(name, type, price) VALUES
('Eiger', "hand bag", 50000),
('Rown', "ransel", 500000),
('Rebook', "tote bag", 75000);

INSERT INTO period(start_date, end_date, margin_percentage) VALUES
('2024-01-01', '2024-03-01', 0.5);

INSERT INTO transaction(product_id, email, total, shipping_cost, date, tax, margin) VALUES
(1, "customer@gmail.com", 20000000, 10000, '2024-01-01', 0.10, 200000),
(2, "customer@gmail.com", 30000000, 10000, '2024-02-01', 0.10, 300000),
(3, "customer@gmail.com", 25000000, 10000, '2024-02-01', 0.10, 250000),
(1, "customer@gmail.com", 27000000, 10000, '2024-03-01', 0.10, 270000),
(2, "customer@gmail.com", 28500000, 10000, '2024-03-01', 0.10, 285000);