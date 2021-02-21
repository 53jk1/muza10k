package com.example.muza10k.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PublisherListDTO {
    private List<PublisherDTO> publisherList;

    public PublisherListDTO(List<PublisherDTO> publisherByName) {
    }
}
