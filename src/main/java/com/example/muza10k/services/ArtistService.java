package com.example.muza10k.services;

import com.example.muza10k.api.domain.ArtistDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {

    ArtistDTO getArtistById(Long id);

    List<ArtistDTO> getArtistByFirstName(String firstName);

    List<ArtistDTO> getArtistByLastName(String lastName);

    List<ArtistDTO> getArtistByNick(String nick);



}
