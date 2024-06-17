package dev.polly.pollygray.dto.request;


public record RegisterRequestDTO(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
