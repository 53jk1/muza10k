package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.ArtistDTO;
import com.example.muza10k.model.Artist;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-21T15:30:57+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_275 (AdoptOpenJDK)"
)
@Component
public class ArtistMapperImpl implements ArtistMapper {

    @Override
    public ArtistDTO artistToArtistDTO(Artist artist) {
        if ( artist == null ) {
            return null;
        }

        ArtistDTO artistDTO = new ArtistDTO();

        artistDTO.setId( artist.getId() );
        artistDTO.setFirstName( artist.getFirstName() );
        artistDTO.setLastName( artist.getLastName() );
        artistDTO.setNick( artist.getNick() );

        return artistDTO;
    }
}
