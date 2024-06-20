package dev.polly.pollygray.controller;

import dev.polly.pollygray.dto.mapper.ArtistRequestMapper;
import dev.polly.pollygray.entity.transactions.ArtistRequest;
import dev.polly.pollygray.entity.user.User;
import dev.polly.pollygray.service.ArtistService;
import dev.polly.pollygray.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/artists")
@CrossOrigin
public class ArtistsController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArtistService artistService;

    @PostMapping("/request-to-become-artist")
    public ResponseEntity requestToBecomeArtist(@AuthenticationPrincipal User user) {
        if (user.isArtist() || user.isAdmin()) {
            return ResponseEntity.badRequest().body("You don't need to request to become artist.");
        }
        if (artistService.getRequestByUser(user) != null) {
            return ResponseEntity.badRequest().body("You already made the request, wait for approval.");
        }
        ArtistRequest artistRequest = ArtistRequestMapper.buildArtistRequest(user);
        artistService.addRequest(artistRequest);
        return ResponseEntity.ok().body("Request submitted! Wait for admin approval.");
    }

    @GetMapping("/requests")
    public ResponseEntity getRequestsToBeApproved() {
        var requests = artistService.getRequestsToBeApproved().stream().map(
                artistRequest -> ArtistRequestMapper.artistRequestToDto(artistRequest)
                );
        return ResponseEntity.ok(requests);
    }

    @PutMapping("/approve")
    public ResponseEntity approveUserToBecomeArtist(@RequestParam String userEmail) {
        User userToBeApproved = (User)userService.loadUserByUsername(userEmail);
        ArtistRequest request = artistService.getRequestByUser(userToBeApproved);
        if (request == null) {
            return ResponseEntity.badRequest().body("The user didn't requested to became artist.");
        }

        artistService.approveRequest(request);
        return ResponseEntity.ok("The user was approved!");
    }
}
