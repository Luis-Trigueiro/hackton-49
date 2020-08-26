DELETE FROM brides;
INSERT INTO brides(ID, CREATIONTIME, UPDATETIME, VERSION, FIRSTNAME, LASTNAME, NICKNAME, BIRTHDATE, SEX, ABOUTME, FAVOURITESONG, LOCATION) VALUES
    (1, TIMESTAMP '2020-08-26 08:45:56.468', TIMESTAMP '2020-08-26 08:45:57.468', 0, 'Tiago', 'Patrício', 'Paté Sexy Beast', '2001-02-01', 'M', 'Sexy a ser vulgar', 'Reggaeton', 'Montijo'),
    (2, TIMESTAMP '2020-08-26 08:47:57.468', TIMESTAMP '2020-08-26 08:47:57.468', 0, 'David', 'Ferreira', 'Pikachu', '2001-01-01', 'OTHER', 'RIP', 'Mamma mia!', 'Praia de Mira'),
    (3, TIMESTAMP '2020-08-26 08:49:58.468', TIMESTAMP '2020-08-26 08:49:58.468', 0, 'Sara', 'Lopes', 'saralopes', '1999-01-01', 'F', 'asaraje', 'Dancing Queen', 'Paços de Ferreira');

DELETE FROM proposal;
INSERT INTO proposal(ID, CREATIONTIME, UPDATETIME, VERSION, FULLNAME, EMAIL, MESSAGE, BRIDE_ID) VALUES
    (1, TIMESTAMP '2020-08-27 08:45:56.468', TIMESTAMP '2020-08-27 08:45:57.468', 0, 'Catarina Campino', 'catarinacampino@academiadecodigo.org', 'E quê?', '1');
    