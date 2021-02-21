package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.SongDTO;
import com.example.muza10k.model.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongMapperTest {

    SongMapper songMapper = SongMapper.INSTANCE;

    @Test
    void songToSong() {
        //given
        Song song = new Song();
        song.setId(1L);
        song.setTitle("TITLE");
        //when
        SongDTO songDTO = songMapper.songToSongDTO(song);
        //then
        assertEquals(Long.valueOf(1L), songDTO.getId());
        assertEquals("TITLE", songDTO.getTitle());
    }
}