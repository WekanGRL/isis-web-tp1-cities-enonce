package monprojet.dao;

import monprojet.projections.CountryPopulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import monprojet.entity.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryDAO;

    @Test
    void lesNomsDePaysSontTousDifferents() {
        log.info("On vérifie que les noms de pays sont tous différents ('unique') dans la table 'Country'");
        
        Country paysQuiExisteDeja = new Country("XX", "France");
        try {
            countryDAO.save(paysQuiExisteDeja); // On essaye d'enregistrer un pays dont le nom existe
            fail("On doit avoir une violation de contrainte d'intégrité (unicité)");
        } catch (DataIntegrityViolationException e) {
            // Si on arrive ici, c'est normal, l'exception attendue s'est produite
        }
    }

    @Test
    @Sql("test-data.sql") // On peut charger des données spécifiques pour un test
    void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Country'");
        int combienDePaysDansLeJeuDeTest = 3 + 1; // 3 dans data.sql, 1 dans test-data.sql
        long nombre = countryDAO.count();
        assertEquals(combienDePaysDansLeJeuDeTest, nombre, "On doit trouver 4 pays" );
    }

    @Test
    @Sql("test-data.sql")
    void onCompteLaPopulationDunPays() {
        log.info("On vérifie que la population d'un pays est bien calculée");
        Integer populationFrance = 2200000 + 50000 + 250000 + 85000;
        Integer populationTrouvee = countryDAO.sumCountryPopulation(1);
        assertEquals(populationFrance, populationTrouvee, "La population de la France est de 2 161 000 habitants");
    }

    @Test
    @Sql("test-data.sql")
    void onCompteLaPopulationDeTousLesPays() {
        log.info("On vérifie que la population de tous les pays est bien calculée");
        Integer populationFrance = 2200000 + 50000 + 250000 + 85000;
        Integer populationItalie = 2900000 + 8000 + 380000 + 90000 + 3000;
        Integer populationUK = 9000000 + 1000000 + 500000;
        Integer populationUSA = 8500000 + 4000000 + 2700000;
        Integer populationTotale = populationFrance + populationItalie + populationUSA + populationUK;
        List<CountryPopulation> listeNamePop = countryDAO.findCountryPopulation();

        Integer countPop = 0;
        for (CountryPopulation cp : listeNamePop) {
            countPop += cp.getPopulation();
        }

        assertEquals(populationTotale, countPop, "La population totale est la bonne");
    }
}
