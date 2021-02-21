package com.example.muza10k.repositories;


import com.example.muza10k.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    List<Object> getPublisherByName(String unknown);
}
