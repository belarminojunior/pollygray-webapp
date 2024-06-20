package dev.polly.pollygray.dto.mapper;

import dev.polly.pollygray.dto.response.ArtistRequestResponseDTO;
import dev.polly.pollygray.entity.transactions.ArtistRequest;
import dev.polly.pollygray.entity.user.User;

public class ArtistRequestMapper {
    public static ArtistRequest buildArtistRequest(User user) {
        ArtistRequest artistRequest = new ArtistRequest();
        artistRequest.setUser(user);
        artistRequest.setApproved(false);
        return artistRequest;
    }

    public static ArtistRequestResponseDTO artistRequestToDto(ArtistRequest artistRequest) {
        return new ArtistRequestResponseDTO(
                artistRequest.getUser().getEmail(),
                artistRequest.getId().getDate()
        );
    }
}
