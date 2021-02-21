package com.example.muza10k.tools;

import com.example.muza10k.model.Song;
import com.example.muza10k.repositories.ArtistRepository;
import com.example.muza10k.repositories.PublisherRepository;
import com.example.muza10k.repositories.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements CommandLineRunner {

    SongRepository songRepository;
    ArtistRepository artistRepository;
    PublisherRepository publisherRepository;

    public DBInflater(SongRepository songRepository, ArtistRepository artistRepository, PublisherRepository publisherRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Song number1 = new Song();
        number1.setTitle("Piosenka numer 1");
    }

}
