package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.Country;
import monprojet.projections.CountryPopulation;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {

    /**
     * Calcule la population totale d'un pays
     * @param id
     * @return Le nom du pays et sa population
     */
    @Query("SELECT SUM(c.population) " +
            "FROM City c WHERE c.country.id = :id")
    public Integer sumCountryPopulation(Integer id);
}
