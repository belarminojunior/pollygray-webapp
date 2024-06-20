package dev.polly.pollygray.entity.user;

import dev.polly.pollygray.entity.artwork.Artwork;
import dev.polly.pollygray.entity.artwork.Comment;
import dev.polly.pollygray.entity.artwork.Picture;
import dev.polly.pollygray.entity.artwork.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    private ObjectId id;
    private String email;
    private String password;
    private UserRole role;

    // General information
    private String firstName;
    private String lastName;

    // Artist-specific information
    @DocumentReference
    private Picture profilePicture;
    @DocumentReference
    private Picture bannerPicture;
    private String biography;
    @DocumentReference
    private List<Artwork> artworks;

    public boolean isArtist() {
        return this.role == UserRole.ARTIST;
    }

    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List roles = new ArrayList();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (this.isAdmin()) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if (this.isArtist()) {
            roles.add(new SimpleGrantedAuthority("ROLE_ARTIST"));
        }

        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
