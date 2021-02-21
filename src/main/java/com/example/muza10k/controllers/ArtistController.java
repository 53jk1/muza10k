package com.example.muza10k.controllers;

import com.example.muza10k.api.mapper.ArtistMapper;
import com.example.muza10k.repositories.ArtistRepository;
import com.example.muza10k.repositories.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ArtistController {

    private ArtistRepository artistRepository;
    private SongRepository songRepository;
    private com.example.muza10k.converters.ArtistCommandToArtist artistCommandToArtist;
    private ArtistMapper artistMapper;

    public ArtistController(com.example.muza10k.repositories.ArtistRepository artistRepository, com.example.muza10k.repositories.SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @RequestMapping(value = {"/artists", "/artist/list"})
    public String getArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artist/list";
    }

    @RequestMapping("/artist/{id}/songs")
    public String getArtistSongs(Model model, @PathVariable("id") Long id) {
        Optional<com.example.muza10k.model.Artist> artist = artistRepository.findById(id);

        if (artist.isPresent()) {
            model.addAttribute("songs", songRepository.getAllByArtistsIsContaining(artist.get()));
            model.addAttribute("filter", "artist: " + artist.get().getFirstName() + " " + artist.get().getLastName());
        } else {
            model.addAttribute("songs", new ArrayList<>());
            model.addAttribute("filter", "artist for this id doesn't exist");
        }

        return "song/list";
    }

    @RequestMapping("/artist/{id}/show")
    public String getArtistDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("artist", artistRepository.findById(id).get());
        return "artist/show";
    }

    @RequestMapping("/artist/{id}/delete")
    public String deleteArtist(@PathVariable("id") Long id) {
        artistRepository.deleteById(id);
        return "redirect:/artists";
    }

    @GetMapping
    @RequestMapping("/artist/new")
    public String newSong(Model model){
        model.addAttribute("artist", new com.example.muza10k.commands.ArtistCommand());
        return "artist/addedit";
    }

    @PostMapping("artist")
    public String saveOrUpdate(@ModelAttribute com.example.muza10k.commands.ArtistCommand command){

        Optional<com.example.muza10k.model.Artist> artistOptional = artistRepository.getFirstByFirstNameAndLastName(command.getFirstName(), command.getLastName());

        if (!artistOptional.isPresent()) {
            com.example.muza10k.model.Artist detachedArtist = artistCommandToArtist.convert(command);
            com.example.muza10k.model.Artist savedArtist = artistRepository.save(detachedArtist);
            return "redirect:/artist/" + savedArtist.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such artist in db");
            return "redirect:/artist/" + artistOptional.get().getId() + "/show";
        }
    }
}
