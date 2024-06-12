package dev.polly.pollygray.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String passwordHash;
    private String email;
    private String role;
}
