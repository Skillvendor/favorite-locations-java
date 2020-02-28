package spring5.webapp.spring5webapp.services;

import org.springframework.stereotype.Service;

import spring5.webapp.spring5webapp.api.v1.mapper.CountryMapper;
import spring5.webapp.spring5webapp.api.v1.model.CountryDTO;
import spring5.webapp.spring5webapp.repositories.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
	private final CountryRepository countryRepository;
	private final CountryMapper countryMapper;
	
	public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
		this.countryRepository = countryRepository;
		this.countryMapper = countryMapper;
	}
	
//	@Override
//	public Set<Country> getCountries() {
//		Set<Country> countriesSet = new HashSet<>();
//		countryRepository.findAll().iterator().
//		forEachRemaining(countriesSet::add);
//		return countriesSet;
//	}
	
	 @Override
	 public List<CountryDTO> getAllCountries() {
	        return countryRepository.findBySpotNotNull()
	                .stream()
	                .map(countryMapper::countryToCountryDTO)
	                .collect(Collectors.toList());
    }
}
