package dev.polly.pollygray.entity.artwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "artworks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artwork {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private float price;
    private int quantity;
    private boolean isPublic;
    private List<Picture> pictures;
    @DocumentReference
    private List<Review> reviews;
    @DocumentReference
    private List<Comment> comments;
    @DocumentReference
    private List<Category> categories;
}
