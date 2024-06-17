package dev.polly.pollygray.entity.artwork;

import dev.polly.pollygray.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    private ObjectId id;
    private String body;
    @DocumentReference
    private Comment parentComment;
    @DocumentReference
    private User author;
    @DocumentReference
    private Artwork artwork;
}