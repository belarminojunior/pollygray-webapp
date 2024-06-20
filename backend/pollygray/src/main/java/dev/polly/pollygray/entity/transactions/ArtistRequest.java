package dev.polly.pollygray.entity.transactions;


import dev.polly.pollygray.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "artists-request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistRequest {
    @Id
    private ObjectId id;
    @DocumentReference
    private User user;
    private boolean isApproved;
}
