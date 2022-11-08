CREATE TABLE parqueseBosques (
  id INTEGER PRIMARY KEY,
  name TEXT NOT NULL,
  adress TEXT NOT NULL 
);

CREATE TABLE ciclovias (
    id INTEGER PRIMARY KEY, 
    tipo TEXT NOT NULL, 
    comprimento INTEGER, 
    bairro TEXT NOT NULL,
    asfalto TEXT NOT NULL,
    sinalizacao TEXT NOT NULL
);

CREATE TABLE pracas (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL, 
    adress TEXT NOT  NULL, 
    posgeo decimal
);

CREATE TABLE academiaarLivre (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL, 
    adress TEXT NOT NULL, 
    posgeo decimal
);

CREATE TABLE espacosCulturais (
    id INTEGER PRIMARY KEY, 
    name TEXT NOT NULL, 
    adress TEXT NOT NULL, 
    datacriacao date
);

INSERT INTO parqueseBosques VALUES (1, 'Parque 1', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (2, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (3, 'Parque 3', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (4, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (5, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (6, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (7, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (8, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (9, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (10, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (11, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO parqueseBosques VALUES (12, 'Parque 2', 'RUA TAL, AVN TAL');
INSERT INTO ciclovias VALUES (1, 'ciclovia padrao', 12, 'bairro tal', 'asfalto bao', 'sinalizacao boa');

-- fetch some values
SELECT * FROM parqueseBosques WHERE id = 3;