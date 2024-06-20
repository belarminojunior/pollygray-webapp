package dev.polly.pollygray.repository;

import dev.polly.pollygray.entity.transactions.ArtistRequest;
import dev.polly.pollygray.entity.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRequestRepository extends MongoRepository<ArtistRequest, ObjectId> {
    List<ArtistRequest> findByIsApproved(boolean isApproved);

    ArtistRequest findByUser(User user);
}
