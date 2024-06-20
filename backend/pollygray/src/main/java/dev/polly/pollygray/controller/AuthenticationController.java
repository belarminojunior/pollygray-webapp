package dev.polly.pollygray.controller;

import dev.polly.pollygray.dto.mapper.UserMapper;
import dev.polly.pollygray.dto.request.LoginRequestDTO;
import dev.polly.pollygray.dto.response.LoginResponseDTO;
import dev.polly.pollygray.dto.request.RegisterRequestDTO;
import dev.polly.pollygray.entity.user.User;
import dev.polly.pollygray.security.TokenService;
import dev.polly.pollygray.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated LoginRequestDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(data.email(), token));
        } catch (AuthenticationException ex) {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception ex) {
            // Handle unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @PostMapping("/register")
    private ResponseEntity register(@RequestBody @Validated RegisterRequestDTO data) {
        try {
            // Check if user already exists
            if (userService.loadUserByUsername(data.email()) != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this email already exists");
            }

            // Encrypt password
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

            // Create new User object
            User newUser = UserMapper.registerRequestDtoToUser(data);
            newUser.setPassword(encryptedPassword);

            // Save user to repository (assuming userService handles saving appropriately)
            userService.createUser(newUser);

            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            // Handle unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
