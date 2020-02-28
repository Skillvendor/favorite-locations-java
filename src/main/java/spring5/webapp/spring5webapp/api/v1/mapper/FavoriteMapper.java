package spring5.webapp.spring5webapp.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import spring5.webapp.spring5webapp.api.v1.model.FavoriteDTO;
import spring5.webapp.spring5webapp.domain.Favorite;

@Mapper
public interface FavoriteMapper {

    FavoriteMapper INSTANCE = Mappers.getMapper(FavoriteMapper.class);

    FavoriteDTO favoriteToFavoriteDTO(Favorite favorite);

    Favorite favoriteDtoToFavorite(FavoriteDTO favoriteDTO);
}
