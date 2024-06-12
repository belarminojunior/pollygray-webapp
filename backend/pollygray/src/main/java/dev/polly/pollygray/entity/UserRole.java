package dev.polly.pollygray.entity;

public enum UserRole {
    ADMINISTRATOR("admin"),
    DEFAULT_USER("user"),
    ARTIST("artist");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
