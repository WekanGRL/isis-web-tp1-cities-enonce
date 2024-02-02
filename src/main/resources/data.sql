-- Initialisation des tables
INSERT INTO Country(id, code, name) VALUES
-- Les clés sont auto-générées, donc on ne les spécifie pas
    (default, 'FR', 'France'), -- id = 1
    (default, 'UK', 'United Kingdom'), -- id = 2
    (default, 'US', 'United States of America'); -- id = 3

INSERT INTO City(country_id, id, population, name) VALUES
    ((SELECT id FROM Country WHERE name like '%France%'), default, 2200000, 'Paris'),
    ((SELECT id FROM Country WHERE name like '%United%Kingdom%'), default, 9000000, 'London'),
    ((SELECT id FROM Country WHERE name like '%United%States%'), default, 8500000, 'New York');
-- On peut fixer la valeur des clés auto-générées, mais il faudrait ensuite
-- réinitialiser le compteur de clé auto-générée
-- Attention : la syntaxe est différente selon le SGBD utilisé
-- ALTER TABLE Country ALTER COLUMN id RESTART WITH 4;

