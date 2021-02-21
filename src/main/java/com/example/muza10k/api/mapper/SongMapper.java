package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.SongDTO;
import com.example.muza10k.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    SongDTO songToSongDTO(Song song);
}

