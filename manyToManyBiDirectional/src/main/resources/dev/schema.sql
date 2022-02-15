CREATE TABLE Address
(
  id     BIGINT NOT NULL AUTO_INCREMENT,
  number VARCHAR(255),
  street VARCHAR(255),
  PRIMARY KEY (id)
);


CREATE TABLE Person
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

CREATE TABLE person_addresses
(
  person_id    BIGINT NOT NULL,
  addresses_id BIGINT NOT NULL
);