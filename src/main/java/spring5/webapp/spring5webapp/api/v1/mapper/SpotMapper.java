package spring5.webapp.spring5webapp.api.v1.mapper;

import spring5.webapp.spring5webapp.api.v1.model.SpotDTO;
import spring5.webapp.spring5webapp.domain.Spot;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface SpotMapper {
	SpotMapper INSTANCE = Mappers.getMapper(SpotMapper.class);

    SpotDTO spotToSpotDTO(Spot spot);
}
