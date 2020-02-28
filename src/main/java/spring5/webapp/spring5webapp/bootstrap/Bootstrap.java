package spring5.webapp.spring5webapp.bootstrap;

import spring5.webapp.spring5webapp.domain.*;
import spring5.webapp.spring5webapp.repositories.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private final CountryRepository countryRepository;
	private final FavoriteRepository favoriteRepository;
	private final SpotRepository spotRepository;
	private final ApplicationUserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Bootstrap(CountryRepository countryRepository,
			FavoriteRepository favoriteRepository, SpotRepository spotRepository,
			ApplicationUserRepository userRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder){
		this.countryRepository = countryRepository;
		this.favoriteRepository = favoriteRepository;
		this.spotRepository = spotRepository;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("CATCHED!");
		seedDatabase();
	}
	
	private void seedDatabase() {
	
		System.out.println("HI, I AM RUNNING THIS");
		Country firstCountry = new Country();
		firstCountry.setName("Turkey");
		
		Country secondCountry = new Country();
		secondCountry.setName("Tara fara spot");
		
		ApplicationUser firstUser = new ApplicationUser();
		firstUser.setUsername("Floricel");
		firstUser.setEmail("floricel93@gmail.com");
		firstUser.setPassword(bCryptPasswordEncoder.encode("floricel"));
		userRepository.save(firstUser);		
		
		Spot firstLocation = new Spot();
		firstLocation.setName("Istambul");
		firstLocation.setWind(BigDecimal.valueOf(45.5));
		firstLocation.setCountry(firstCountry);
		
		Spot secondLocation = new Spot();
		secondLocation.setName("Locatie fara tara");
		secondLocation.setWind(BigDecimal.valueOf(20.5));
		
		Spot thirdLocation = new Spot();
		thirdLocation.setName("Bahamar");
		thirdLocation.setWind(BigDecimal.valueOf(8));
		thirdLocation.setCountry(secondCountry);
				
		Favorite firstFavorite = new Favorite();
		firstFavorite.setSpot(firstLocation);
		firstFavorite.setUser(firstUser);
		
		firstLocation.getFavorite().add(firstFavorite);
		firstCountry.getSpot().add(firstLocation);
		secondCountry.getSpot().add(thirdLocation);
		
		countryRepository.save(firstCountry);
		countryRepository.save(secondCountry);
	}
}
	

