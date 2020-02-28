package spring5.webapp.spring5webapp.repositories;

import spring5.webapp.spring5webapp.domain.Country;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
	//@Query("SELECT C FROM COUNTRY C LEFT JOIN SPOT ON COUNTRY.ID = SPOT.COUNTRY_ID WHERE SPOT.ID IS NOT NULL")
	List<Country> findBySpotNotNull();
}
