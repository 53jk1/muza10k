package com.example.muza10k.repositories;


import com.example.muza10k.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Optional<Artist> getFirstByFirstNameAndLastName(String firstName, String lastName);
    Optional<Artist> getFirstByFirstName(String firstName);

    Collection<Artist> getByFirstName(String firstName);

    List<Artist> getLastByLastName(String lastName);

    List<Artist> getByNick(String nick);
}

