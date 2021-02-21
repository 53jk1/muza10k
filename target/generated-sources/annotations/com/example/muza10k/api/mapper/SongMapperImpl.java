package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.SongDTO;
import com.example.muza10k.model.Song;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-20T19:52:45+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_275 (AdoptOpenJDK)"
)
@Component
public class SongMapperImpl implements SongMapper {

    @Override
    public SongDTO songToSongDTO(Song song) {
        if ( song == null ) {
            return null;
        }

        SongDTO songDTO = new SongDTO();

        songDTO.setId( song.getId() );
        songDTO.setTitle( song.getTitle() );
        songDTO.setGenre( song.getGenre() );
        songDTO.setIsmn( song.getIsmn() );
        songDTO.setYear( song.getYear() );

        return songDTO;
    }
}
