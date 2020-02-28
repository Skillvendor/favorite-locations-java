package spring5.webapp.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import spring5.webapp.spring5webapp.domain.Spot;

public interface SpotRepository extends JpaRepository<Spot, Long>, JpaSpecificationExecutor<Spot>{

}
