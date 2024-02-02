package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.Country;
import monprojet.projections.CountryPopulation;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {

    /**
     * Calcule la population totale d'un pays
     * @param id
     * @return La population du pays
     */
    @Query("SELECT SUM(c.population) " +
            "FROM City c WHERE c.country.id = :id")
    public Integer sumCountryPopulation(Integer id);

    /**
     * Récupère le nom et la population de tous les pays
     * @return Liste (nom du pays, population)
     */
    @Query("SELECT c.country.name as name, SUM(c.population) as population " +
            "FROM City c " +
            "GROUP BY c.country.name")
    public List<CountryPopulation> findCountryPopulation();
}
