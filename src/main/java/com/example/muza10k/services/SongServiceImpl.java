package com.example.muza10k.services;

import com.example.muza10k.api.domain.SongDTO;
import com.example.muza10k.api.mapper.SongMapper;
import com.example.muza10k.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    SongRepository songRepository;
    SongMapper songMapper;

    public SongServiceImpl(SongRepository songRepository, SongMapper songMapper) {
        this.songRepository = songRepository;
        this.songMapper = songMapper;
    }

    @Override
    public SongDTO getSongById(Long id) {
        return songMapper.songToSongDTO(songRepository.findById(id).get());
    }

    @Override
    public List<SongDTO> getSongByTitle(String title) {
        return null;
    }

    @Override
    public List<SongDTO> getSongByIsmn(String ismn) {
        return null;
    }

    @Override
    public List<SongDTO> getSongByYear(String year) {
        return null;
    }

    @Override
    public List<SongDTO> getSongByGenre(String genre) {
        return null;
    }

}
