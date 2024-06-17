package dev.polly.pollygray.dto.request;

import dev.polly.pollygray.entity.user.UserRole;

public record RegisterDTO(
        String firstName,
        String lastName,
        String email,
        String password,
        UserRole role
) {
}
