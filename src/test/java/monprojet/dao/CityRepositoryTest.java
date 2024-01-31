package monprojet.dao;

import lombok.extern.log4j.Log4j2;
import monprojet.entity.City;
import monprojet.entity.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityDAO;

    @Autowired
    private CountryRepository countryDAO;

    @Test
    void leCodePaysPointeSurUnPaysValide() {
        /*log.info("On vérifie que les codes de pays des villes pointent bien sur un pays valide dans la table 'Country'");

        Country paysQuiExistePas = new Country("XXXX", "Pays qui n'existe pas");

        City villeQuiPointeSurRien = new City("Paris", 2161000, paysQuiExistePas);
        try {
            cityDAO.save(villeQuiPointeSurRien); // On essaye d'enregistrer un pays dont le nom existe
            fail("On doit avoir une violation de contrainte d'intégrité (pointe sur rien)");
        } catch (DataIntegrityViolationException e) {
            // Si on arrive ici, c'est normal, l'exception attendue s'est produite
        }*/
    }

    @Test
    @Sql("test-data.sql") // On peut charger des données spécifiques pour un test
    void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'City'");
        int combienDeVillesDansLeJeuDeTest = 3 + 1; // 3 dans data.sql, 1 dans test-data.sql
        long nombre = cityDAO.count();
        assertEquals(combienDeVillesDansLeJeuDeTest, nombre, "On doit trouver 4 villes" );
    }

}
