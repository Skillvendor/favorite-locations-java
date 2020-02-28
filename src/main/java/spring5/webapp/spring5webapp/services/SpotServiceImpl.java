package spring5.webapp.spring5webapp.services;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import spring5.webapp.spring5webapp.api.v1.mapper.SpotMapper;
import spring5.webapp.spring5webapp.api.v1.model.SpotDTO;
import spring5.webapp.spring5webapp.domain.Spot;
import spring5.webapp.spring5webapp.repositories.SpotRepository;
import spring5.webapp.spring5webapp.searchfilters.SearchCriteria;
import spring5.webapp.spring5webapp.searchfilters.SpotSearchParameters;
import spring5.webapp.spring5webapp.searchfilters.SpotSpecification;
import spring5.webapp.spring5webapp.searchfilters.SpotSpecificationsBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SpotServiceImpl implements SpotService {
	final SpotRepository spotRepository;
	private final SpotMapper spotMapper;
	
	public SpotServiceImpl(SpotRepository spotRepository, SpotMapper spotMapper) {
		this.spotRepository = spotRepository;
		this.spotMapper = spotMapper;
	}
	
    @Override
    public List<SpotDTO> getAllSpots(SpotSearchParameters spotSearchParameters) {
//    	SpotSpecificationsBuilder builder = new SpotSpecificationsBuilder();
//    	builder.with(new SearchCriteria("name", "country:", "Tara fara spot", false));
//    	builder.with(new SearchCriteria("wind", ">", 0.0, true));
    	
//    	Specification<Spot> spec = builder.build();
       	     
        return spotRepository.findAll(spotSearchParameters.getAllFilteredSpots())
                .stream()
                .map(spotMapper::spotToSpotDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public SpotDTO getSpotById(Long id) {

        return spotRepository.findById(id)
                .map(spotMapper::spotToSpotDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
