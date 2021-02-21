package com.example.muza10k.control;

import com.example.muza10k.api.domain.ArtistDTO;
import com.example.muza10k.api.domain.ArtistListDTO;
import com.example.muza10k.services.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/artist/")
public class ArtistControl {



    private final ArtistService artistService;

    public ArtistControl(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("{id}")
    public ResponseEntity<ArtistDTO> getArtistById(@PathVariable Long id) {
        return new ResponseEntity<ArtistDTO>(artistService.getArtistById(id), HttpStatus.OK);
    }

    @GetMapping("findByFirstName")
    public ResponseEntity<ArtistListDTO> getArtistsByFirstName(@RequestParam String firstName) {
        return new ResponseEntity<ArtistListDTO>(
                new ArtistListDTO(artistService.getArtistByFirstName(firstName)), HttpStatus.OK
        );
    }

    @GetMapping("findByLastName")
    public ResponseEntity<ArtistListDTO> getArtistsByLastName(@RequestParam String lastName) {
        return new ResponseEntity<ArtistListDTO>(
                new ArtistListDTO(artistService.getArtistByLastName(lastName)), HttpStatus.OK
        );
    }

    @GetMapping("findByNick")
    public ResponseEntity<ArtistListDTO> getArtistsByNick(@RequestParam String nick) {
        return new ResponseEntity<ArtistListDTO>(
                new ArtistListDTO(artistService.getArtistByNick(nick)), HttpStatus.OK
        );
    }
}
