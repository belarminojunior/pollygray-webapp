package dev.polly.pollygray.entity.artwork;

import dev.polly.pollygray.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private String id;
    private int stars;
    private String body;
    @DocumentReference
    private User author;
    @DocumentReference
    private Artwork artwork;
}