package com.example.muza10k.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ArtistListDTO {

    private List<ArtistDTO> artistList;

    public ArtistListDTO(List<ArtistDTO> artistByFirstName) {
    }
}
