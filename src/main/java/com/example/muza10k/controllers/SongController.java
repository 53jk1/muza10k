package com.example.muza10k.controllers;

import com.example.muza10k.repositories.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SongController {

    private SongRepository songRepository;
    private com.example.muza10k.converters.SongCommandToSong songCommandToSong;
    private com.example.muza10k.repositories.PublisherRepository publisherRepository;
    private com.example.muza10k.repositories.ArtistRepository artistRepository;

    public SongController(SongRepository songRepository, com.example.muza10k.converters.SongCommandToSong songCommandToSong, com.example.muza10k.repositories.PublisherRepository publisherRepository, com.example.muza10k.repositories.ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.songCommandToSong = songCommandToSong;
        this.publisherRepository = publisherRepository;
        this.artistRepository = artistRepository;
    }

    @org.springframework.web.bind.annotation.GetMapping
    @RequestMapping(value = {"/songs" , "song/list"})
    public String getSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song/list";
    }

    @org.springframework.web.bind.annotation.GetMapping
    @RequestMapping("/song/{id}/show")
    public String getSongDetails(Model model, @org.springframework.web.bind.annotation.PathVariable("id") Long id) {
        model.addAttribute("song", songRepository.findById(id).get());
        return "song/show";
    }

    @org.springframework.web.bind.annotation.GetMapping
    @RequestMapping("/song/{id}/delete")
    public String deleteSong(@org.springframework.web.bind.annotation.PathVariable("id") Long id) {
        songRepository.deleteById(id);
        return "redirect:/songs";
    }

    @org.springframework.web.bind.annotation.GetMapping
    @RequestMapping("/song/new")
    public String newSong(Model model){
        model.addAttribute("song", new com.example.muza10k.commands.SongCommand());
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("artists", artistRepository.findAll());
        return "song/addedit";
    }

    @org.springframework.web.bind.annotation.PostMapping("song")
    public String saveOrUpdate(@org.springframework.web.bind.annotation.ModelAttribute com.example.muza10k.commands.SongCommand command){
        com.example.muza10k.model.Song detachedSong = songCommandToSong.convert(command);
        com.example.muza10k.model.Song savedSong = songRepository.save(detachedSong);

        return "redirect:/song/" + savedSong.getId() + "/show";
    }
}