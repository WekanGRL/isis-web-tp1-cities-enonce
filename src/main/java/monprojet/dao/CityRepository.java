package monprojet.dao;

import monprojet.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CityRepository extends JpaRepository<City, Integer> {

}
