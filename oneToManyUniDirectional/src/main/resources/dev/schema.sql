CREATE TABLE Person
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

CREATE TABLE Phone
(
  id        BIGINT NOT NULL AUTO_INCREMENT,
  number    VARCHAR(255),
  person_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (person_id) REFERENCES Person
);

CREATE TABLE person_phones
(
  Person_id BIGINT NOT NULL,
  phones_id BIGINT NOT NULL
);
