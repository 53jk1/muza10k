package com.example.muza10k.repositories;

import com.example.muza10k.model.Artist;
import com.example.muza10k.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

    List<Song> getAllByArtistsIsContaining(Artist artist);

    Optional<Song> getFirstByIsmn(String ismn);
}
