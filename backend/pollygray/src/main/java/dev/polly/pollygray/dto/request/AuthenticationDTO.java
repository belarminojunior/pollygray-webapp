package dev.polly.pollygray.dto.request;

public record AuthenticationDTO(
        String email,
        String password
) {
}
