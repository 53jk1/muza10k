package com.example.muza10k.tools;

import com.example.muza10k.model.Artist;
import com.example.muza10k.model.Publisher;
import com.example.muza10k.model.Song;
import com.example.muza10k.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.example.muza10k.repositories.ArtistRepository;
import com.example.muza10k.repositories.SongRepository;


@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(SongRepository songRepository, ArtistRepository artistRepository, PublisherRepository publisherRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.publisherRepository = publisherRepository;
    }

    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Artist mata = new Artist("Michal", "Matczak", "MATA");
        Publisher sbmaffija = new Publisher("SB Maffija");
        Song hot16challenge = new Song("Hot16Challenge", "Rap", "1983129873",
                "2020", sbmaffija);
        mata.getSongs().add(hot16challenge);
        hot16challenge.getArtists().add(mata);
        publisherRepository.save(sbmaffija);
        artistRepository.save(mata);
        songRepository.save(hot16challenge);


        Artist kartky = new Artist("Jakub", "Jankowski", "Kartky");
        Publisher quequality = new Publisher("QueQuality");
        Song outside = new Song("Outside", "Hip-Hop", "98172391123",
                "2018",  quequality);
        kartky.getSongs().add(outside);
        outside.getArtists().add(kartky);
        publisherRepository.save(quequality);
        artistRepository.save(kartky);
        songRepository.save(outside);



        Artist bedoes = new Artist("Borys", "Przybylski", "BEDOES");
        Publisher sbmlabel = new Publisher("SBM Label");
        Song nadchodzilato = new Song("Nadchodzi Lato", "Rap", "09309823091",
                "2019",  sbmlabel);
        bedoes.getSongs().add(nadchodzilato);
        nadchodzilato.getArtists().add(bedoes);
        publisherRepository.save(sbmlabel);
        artistRepository.save(bedoes);
        songRepository.save(nadchodzilato);
    }
}
