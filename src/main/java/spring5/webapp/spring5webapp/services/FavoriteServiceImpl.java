package spring5.webapp.spring5webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5.webapp.spring5webapp.api.v1.mapper.FavoriteMapper;
import spring5.webapp.spring5webapp.api.v1.model.FavoriteDTO;
import spring5.webapp.spring5webapp.domain.Favorite;
import spring5.webapp.spring5webapp.repositories.ApplicationUserRepository;
import spring5.webapp.spring5webapp.repositories.FavoriteRepository;
import spring5.webapp.spring5webapp.services.FavoriteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	private FavoriteMapper favoriteMapper;
	private FavoriteRepository favoriteRepository;
	private ApplicationUserRepository applicationUserRepository;
	
//	public FavoriteServiceImpl(FavoriteRepository favoriteRepository, FavoriteMapper favoriteMapper) {
//		this.favoriteRepository = favoriteRepository;
//		this.favoriteMapper = favoriteMapper;
//	}
	
 	@Autowired
    public void setFavoriteMapper(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }
    @Autowired
    public void setFavoriteRepository(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }
    
    @Autowired
    public void setApplicationUserRepository(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public List<FavoriteDTO> getAllFavorites() {
        return favoriteRepository
                .findAll()
                .stream()
                .map(favoriteMapper::favoriteToFavoriteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FavoriteDTO getFavoriteById(Long id) {

        return favoriteRepository.findById(id)
                .map(favoriteMapper::favoriteToFavoriteDTO)
                .orElseThrow(ResourceNotFoundException::new); 
    }

    @Override
    public FavoriteDTO createNewFavorite(FavoriteDTO favoriteDTO, String username) {

    	System.out.println("AFISAM FAVORITE DTO");
    	System.out.println(favoriteDTO);
        Favorite favorite = favoriteMapper.favoriteDtoToFavorite(favoriteDTO);
        favorite.setUser(applicationUserRepository.findByUsername(username));
        System.out.println("AFISAm FAVORITE");
        System.out.println(favorite.getSpot());

        Favorite savedFavorite = favoriteRepository.save(favorite);

        FavoriteDTO returnDto = favoriteMapper.favoriteToFavoriteDTO(savedFavorite);

        return returnDto;
    }
    
    @Override
    public void deleteFavoriteById(Long id) {
    	favoriteRepository.deleteById(id);
    }
}
//.map(favorite -> {
//FavoriteDTO favoriteDTO = favoriteMapper.favoriteToFavoriteDTO(favorite);
//System.out.println(favorite.getUser());
//System.out.println(favorite.getSpot());
//UserDTO userDTO = userMapper.userToUserDTO(favorite.getUser());
//SpotDTO spotDTO = spotMapper.spotToSpotDTO(favorite.getSpot());
//favoriteDTO.setUser(userDTO);
//favoriteDTO.setSpot(spotDTO);
//
//return favoriteDTO;
//})