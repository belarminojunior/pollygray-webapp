package dev.polly.pollygray.repository;

import dev.polly.pollygray.entity.Artwork;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends MongoRepository<Artwork, ObjectId> {
}
