INSERT INTO Person (id)
VALUES (1),
       (4);


INSERT INTO Address (number, street, id)
VALUES ('12A', '12th Avenue', 2),
       ('18B', '18th Avenue', 3);

INSERT INTO person_addresses (person_id, addresses_id)
VALUES (1, 2),
       (1, 3),
       (4, 2);