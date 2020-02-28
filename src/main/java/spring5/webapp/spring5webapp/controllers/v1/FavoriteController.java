package spring5.webapp.spring5webapp.controllers.v1;

import static spring5.webapp.spring5webapp.constants.SecurityConstants.HEADER_STRING;
import static spring5.webapp.spring5webapp.constants.SecurityConstants.SECRET;
import static spring5.webapp.spring5webapp.constants.SecurityConstants.TOKEN_PREFIX;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import spring5.webapp.spring5webapp.api.v1.model.FavoriteDTO;
import spring5.webapp.spring5webapp.api.v1.model.FavoriteListDTO;
import spring5.webapp.spring5webapp.services.FavoriteService;

@RestController
@RequestMapping("/api/favorites/spots")
public class FavoriteController {
	private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public FavoriteListDTO index(){
        return new FavoriteListDTO(favoriteService.getAllFavorites());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public FavoriteDTO getFavoriteById(@PathVariable Long id){
        return favoriteService.getFavoriteById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FavoriteDTO createNewFavorite(HttpServletRequest request, @RequestBody FavoriteDTO favoriteDTO){
    	String token = request.getHeader(HEADER_STRING);
    	String username = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                .build()
                .verify(token.replace(TOKEN_PREFIX, ""))
                .getSubject();
    	
    	return favoriteService.createNewFavorite(favoriteDTO, username);
    }
    
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteFavoriteById(@PathVariable Long id){
    	favoriteService.deleteFavoriteById(id);
    }
}
