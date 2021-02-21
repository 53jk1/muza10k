package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.ArtistDTO;
import com.example.muza10k.model.Artist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistMapperTest {

    ArtistMapper artistMapper = ArtistMapper.INSTANCE;

    @Test
    void artistToArtistDTO() {
        //given
        Artist artist = new Artist();
        artist.setId(4L);
        artist.setFirstName("ARTIST");
        artist.setLastName("ARTIST1");
        artist.setNick("4RT15T");
        //when
        ArtistDTO artistDTO = artistMapper.artistToArtistDTO(artist);
        //then
        assertEquals(Long.valueOf(4L), artistDTO.getId());
        assertEquals("ARTIST", artistDTO.getFirstName());
        assertEquals("ARTIST1", artistDTO.getLastName());
        assertEquals("4RT15T", artistDTO.getNick());
    }
}