package dev.polly.pollygray.entity.user;

public record RegisterDTO(
        String firstName,
        String lastName,
        String email,
        String password,
        UserRole role
) {
}
