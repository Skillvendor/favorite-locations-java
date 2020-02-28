package spring5.webapp.spring5webapp.services;

import java.util.List;
import java.util.Set;

import spring5.webapp.spring5webapp.api.v1.model.SpotDTO;
import spring5.webapp.spring5webapp.domain.Spot;
import spring5.webapp.spring5webapp.searchfilters.SpotSearchParameters;

public interface SpotService {
	List<SpotDTO> getAllSpots(SpotSearchParameters spotSearchParameters);

	SpotDTO getSpotById(Long id);

}
