package spring5.webapp.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring5.webapp.spring5webapp.domain.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
