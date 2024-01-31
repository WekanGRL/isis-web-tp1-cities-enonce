-- Initialisation spécifiques pour un jeu de test
INSERT INTO Country(code, name) VALUES
    ('IT', 'Italie');

INSERT INTO City(country_id, population, name) VALUES
    (4, 2873000, 'Rome')