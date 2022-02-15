CREATE TABLE Phone
(
  id        BIGINT NOT NULL AUTO_INCREMENT,
  number    VARCHAR(255),
  PRIMARY KEY (id)
);


CREATE TABLE phonesdetails
(
  id         BIGINT NOT NULL AUTO_INCREMENT,
  provider   varchar(255),
  technology varchar(255),
  phone_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (phone_id) REFERENCES Phone
);

