package dev.polly.pollygray.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
//    private Picture[] pictures;
//    private Review[] reviews;
//    private Comment[] comments;
//    private Category category;

}
