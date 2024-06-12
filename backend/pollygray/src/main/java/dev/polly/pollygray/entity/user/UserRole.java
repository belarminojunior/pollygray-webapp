package dev.polly.pollygray.entity.user;

public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    ARTIST("artist");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
