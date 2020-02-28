package spring5.webapp.spring5webapp.services;

import java.util.List;

import spring5.webapp.spring5webapp.api.v1.model.CountryDTO;

public interface CountryService {
	List<CountryDTO> getAllCountries();
}
