package dev.polly.pollygray.service;

import dev.polly.pollygray.entity.transactions.ArtistRequest;
import dev.polly.pollygray.entity.user.User;
import dev.polly.pollygray.entity.user.UserRole;
import dev.polly.pollygray.repository.ArtistRequestRepository;
import dev.polly.pollygray.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRequestRepository artistRequestRepository;
    @Autowired
    private UserRepository userRepository;

    public ArtistRequest addRequest(ArtistRequest artistRequest) {
        return artistRequestRepository.save(artistRequest);
    }

    public List<ArtistRequest> getRequestsToBeApproved() {
        return artistRequestRepository.findByIsApproved(false);
    }

    public ArtistRequest getRequestByUser(User user) {
        return artistRequestRepository.findByUser(user);
    }

    public boolean approveRequest(ArtistRequest request) {
        request.getUser().setRole(UserRole.ARTIST);
        request.setApproved(true);
        artistRequestRepository.save(request);
        userRepository.save(request.getUser());
        return true; // TODO: handle errors
    }
}

