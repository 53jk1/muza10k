package com.example.muza10k.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SongListDTO {
    private List<SongDTO> songList;

    public SongListDTO(List<SongDTO> songByTitle) {
    }
}
