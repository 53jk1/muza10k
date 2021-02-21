package com.example.muza10k.services;

import com.example.muza10k.api.domain.ArtistDTO;
import com.example.muza10k.api.mapper.ArtistMapper;
import com.example.muza10k.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;
    private ArtistMapper artistMapper;

    public ArtistServiceImpl(ArtistRepository artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }

    @Override
    public ArtistDTO getArtistById(Long id) {
        return artistMapper.artistToArtistDTO(artistRepository.findById(id).get());
    }

    @Override
    public List<ArtistDTO> getArtistByFirstName(String firstName) {
        return artistRepository.getByFirstName(firstName)
                .stream()
                .map(artistMapper::artistToArtistDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArtistDTO> getArtistByLastName(String lastName) {
        return artistRepository.getLastByLastName(lastName)
                .stream()
                .map(artistMapper::artistToArtistDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArtistDTO> getArtistByNick(String nick) {
        return artistRepository.getByNick(nick)
                .stream()
                .map(artistMapper::artistToArtistDTO)
                .collect(Collectors.toList());
    }
}
