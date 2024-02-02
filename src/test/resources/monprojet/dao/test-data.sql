-- Initialisation spécifiques pour un jeu de test
INSERT INTO Country(code, name) VALUES
    ('IT', 'Italy');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%Italy%'), 2900000, 'Rome');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%France%'), 50000, 'Bayonne');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%France%'), 250000, 'Bordeaux');

INSERT INTO City(country_id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%France%'), 85000, 'Pau'),
    ((SELECT id FROM Country WHERE name like '%United%Kingdom%'), 1000000, 'Manchester'),
    ((SELECT id FROM Country WHERE name like '%United%Kingdom%'), 500000, 'Birmingham'),
    ((SELECT id FROM Country WHERE name like '%United%States%'), 4000000, 'Los Angeles'),
    ((SELECT id FROM Country WHERE name like '%United%States%'), 2700000, 'Chicago'),
    ((SELECT id FROM Country WHERE name like '%Italy%'), 8000, 'San Gimignano'),
    ((SELECT id FROM Country WHERE name like '%Italy%'), 380000, 'Florence'),
    ((SELECT id FROM Country WHERE name like '%Italy%'), 90000, 'Pise'),
    ((SELECT id FROM Country WHERE name like '%Italy%'), 3000, 'Monteriggioni');