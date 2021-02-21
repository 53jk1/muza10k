package com.example.muza10k.services;

import com.example.muza10k.api.domain.PublisherDTO;
import com.example.muza10k.api.mapper.PublisherMapper;
import com.example.muza10k.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    PublisherRepository publisherRepository;
    PublisherMapper publisherMapper;

    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Override
    public PublisherDTO getPublisherById(Long id) {
        return publisherMapper.publisherToPublisherDTO(publisherRepository.findById(id).get());
    }

    @Override
    public List<PublisherDTO> getPublisherByName(String names) {
        return null;
    }


}
