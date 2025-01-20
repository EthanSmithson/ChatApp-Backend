package com.example.chatapp.models;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;

    public User(Long id, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getUserEmail() {
        return this.email;
    }

    public String getUserUsername() {
        return this.username;
    }

    public Long getUserId() {
        return this.id;
    }

}