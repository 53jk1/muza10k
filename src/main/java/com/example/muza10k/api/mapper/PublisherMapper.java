package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.PublisherDTO;
import com.example.muza10k.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherDTO publisherToPublisherDTO(Publisher publisher);
}
