package spring5.webapp.spring5webapp.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import spring5.webapp.spring5webapp.api.v1.model.CountryDTO;
import spring5.webapp.spring5webapp.domain.Country;

@Mapper
public interface CountryMapper {
	CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDTO countryToCountryDTO(Country country);
}
