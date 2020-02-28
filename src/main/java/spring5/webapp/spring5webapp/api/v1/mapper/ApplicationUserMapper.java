package spring5.webapp.spring5webapp.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


import spring5.webapp.spring5webapp.api.v1.model.ApplicationUserDTO;
import spring5.webapp.spring5webapp.domain.ApplicationUser;

@Mapper
public interface ApplicationUserMapper {
	ApplicationUserMapper INSTANCE = Mappers.getMapper(ApplicationUserMapper.class);

    ApplicationUserDTO applicationUserToApplicationUserDTO(ApplicationUser user);
}
