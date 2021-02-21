package com.example.muza10k.control;


import com.example.muza10k.api.domain.SongDTO;
import com.example.muza10k.api.domain.SongListDTO;
import com.example.muza10k.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/song/")
public class SongControl {

    private final SongService songService;

    public SongControl(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("{id}")
    public ResponseEntity<SongDTO> getSongById(@PathVariable Long id) {
        return new ResponseEntity<SongDTO>(songService.getSongById(id), HttpStatus.OK);
    }

    @GetMapping("findByTitle")
    public ResponseEntity<SongListDTO> getSongByTitle(@RequestParam String title) {
        return new ResponseEntity<SongListDTO>(
                new SongListDTO(songService.getSongByTitle(title)), HttpStatus.OK
        );
    }
    @GetMapping("findByGenre")
    public ResponseEntity<SongListDTO> getSongByGenre(@RequestParam String genre) {
        return new ResponseEntity<SongListDTO>(
                new SongListDTO(songService.getSongByGenre(genre)), HttpStatus.OK
        );
    }
    @GetMapping("findByIsmn")
    public ResponseEntity<SongListDTO> getSongByIsmn(@RequestParam String ismn) {
        return new ResponseEntity<SongListDTO>(
                new SongListDTO(songService.getSongByIsmn(ismn)), HttpStatus.OK
        );
    }
    @GetMapping("findByYear")
    public ResponseEntity<SongListDTO> getSongByYear(@RequestParam String year) {
        return new ResponseEntity<SongListDTO>(
                new SongListDTO(songService.getSongByYear(year)), HttpStatus.OK
        );
    }
}
