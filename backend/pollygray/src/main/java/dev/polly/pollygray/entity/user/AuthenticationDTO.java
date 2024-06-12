package dev.polly.pollygray.entity.user;

public record AuthenticationDTO(
        String email,
        String password
) {
}
