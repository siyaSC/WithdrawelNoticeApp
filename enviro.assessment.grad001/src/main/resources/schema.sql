CREATE TABLE investor (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  address VARCHAR(255),
  email VARCHAR(255) NOT NULL,
  contact_number VARCHAR(20),
  date_of_birth VARCHAR(20) NOT NULL
);