package dev.polly.pollygray.controller;

import dev.polly.pollygray.entity.artwork.Artwork;
import dev.polly.pollygray.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/artworks")
public class ArtworkController {
    @Autowired
    private ArtworkService artworkService;

    @GetMapping
    public ResponseEntity<List<Artwork>> getAll() {
        return new ResponseEntity<List<Artwork>>(artworkService.getAll(), HttpStatus.OK);
    }
    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Artwork> create(@RequestBody Artwork artwork) {
        return new ResponseEntity<Artwork>(artworkService.createArtwork(artwork), HttpStatus.OK);
    }
}
