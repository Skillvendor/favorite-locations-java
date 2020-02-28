package spring5.webapp.spring5webapp.services;

import spring5.webapp.spring5webapp.api.v1.model.FavoriteDTO;
import spring5.webapp.spring5webapp.domain.Favorite;

import java.util.List;

public interface FavoriteService {
	
	List<FavoriteDTO> getAllFavorites();

	FavoriteDTO createNewFavorite(FavoriteDTO favoriteDTO, String username);
	
	FavoriteDTO getFavoriteById(Long id);
	
	void deleteFavoriteById(Long id);
	
}
