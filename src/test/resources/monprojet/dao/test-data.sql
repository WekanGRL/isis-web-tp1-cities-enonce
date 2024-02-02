-- Initialisation spécifiques pour un jeu de test
INSERT INTO Country(code, name) VALUES
    ('IT', 'Italy');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%Italy%'), 2873000, 'Rome');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%France%'), 50000, 'Bayonne');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%France%'), 250000, 'Bordeaux');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%France%'), 85000, 'Pau');
