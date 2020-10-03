CREATE TABLE language
(
    name        VARCHAR(100) NOT NULL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    rating      INTEGER      NOT NULL
);

insert into language (name, description, rating)
VALUES ('Java', 'primary', 5);
insert into language (name, description, rating)
VALUES ('C#', 'secondary', 4);