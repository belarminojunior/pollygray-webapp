package dev.polly.pollygray.dto.response;

public record LoginResponseDTO(
        String userEmail,
        String token
) {
}
