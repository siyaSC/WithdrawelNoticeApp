CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    investor_id BIGINT,
    FOREIGN KEY (investor_id) REFERENCES investor(id)
);