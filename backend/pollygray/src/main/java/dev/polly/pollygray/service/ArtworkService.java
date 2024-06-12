package dev.polly.pollygray.service;

import dev.polly.pollygray.entity.artwork.Artwork;
import dev.polly.pollygray.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService {
    @Autowired
    private ArtworkRepository artworkRepository;

    public List<Artwork> getAll() {
        return artworkRepository.findAll();
    }

    public Artwork createArtwork(Artwork artwork) {
        return artworkRepository.insert(artwork);
    }
}
