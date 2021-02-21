package com.example.muza10k.api.mapper;

import com.example.muza10k.api.domain.PublisherDTO;
import com.example.muza10k.model.Publisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublisherMapperTest {

    PublisherMapper publisherMapper = PublisherMapper.INSTANCE;

    @Test
    void publisherToPublisher() {
        //given
        Publisher publisher = new Publisher();
        publisher.setId(2L);
        publisher.setName("PUBLISHER");
        publisher.setNip("9999999999");
        //when
        PublisherDTO publisherDTO = publisherMapper.publisherToPublisherDTO(publisher);
        //then
        assertEquals(Long.valueOf(2L), publisherDTO.getId());
        assertEquals("PUBLISHER", publisherDTO.getName());
        assertEquals("9999999999", publisherDTO.getNip());
    }
}