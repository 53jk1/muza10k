package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.ArtistDTO;
import com.example.muza10k.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    ArtistDTO artistToArtistDTO(Artist artist);
}
