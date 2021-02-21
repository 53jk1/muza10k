package com.example.muza10k.control;

import com.example.muza10k.api.domain.PublisherDTO;
import com.example.muza10k.api.domain.PublisherListDTO;
import com.example.muza10k.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/publisher/")
public class PublisherControl {

    private final PublisherService publisherService;

    public PublisherControl(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Long id) {
        return new ResponseEntity<PublisherDTO>(publisherService.getPublisherById(id), HttpStatus.OK);
    }

    @GetMapping("findByName")
    public ResponseEntity<PublisherListDTO> getPublisherByName(@RequestParam String name) {
        return new ResponseEntity<PublisherListDTO>(
                new PublisherListDTO(publisherService.getPublisherByName(name)), HttpStatus.OK
        );
    }

    @GetMapping("findByNip")
    public ResponseEntity<PublisherListDTO> getPublisherByNip(@RequestParam String nip) {
        return new ResponseEntity<PublisherListDTO>(
                new PublisherListDTO(publisherService.getPublisherByName(nip)), HttpStatus.OK
        );
    }

    @GetMapping("findByAddress")
    public ResponseEntity<PublisherListDTO> getPublisherByAddress(@RequestParam String address) {
        return new ResponseEntity<PublisherListDTO>(
                new PublisherListDTO(publisherService.getPublisherByName(address)), HttpStatus.OK
        );
    }
}

