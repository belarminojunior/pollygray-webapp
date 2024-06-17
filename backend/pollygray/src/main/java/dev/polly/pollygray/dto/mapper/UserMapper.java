package dev.polly.pollygray.dto.mapper;

import dev.polly.pollygray.dto.request.RegisterRequestDTO;
import dev.polly.pollygray.entity.user.User;

public class UserMapper {
    public static User registerRequestDtoToUser(RegisterRequestDTO requestDTO) {
        User user = new User();
        user.setFirstName(requestDTO.firstName());
        user.setLastName(requestDTO.lastName());
        user.setEmail(requestDTO.email());
        user.setPassword(requestDTO.password());
        return user;
    }
}
