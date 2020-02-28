package spring5.webapp.spring5webapp.repositories;

import spring5.webapp.spring5webapp.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{

	ApplicationUser findByUsername(String username);

}
