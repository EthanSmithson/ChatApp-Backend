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
    private Integer confirmed;

    public User(Long id, String firstName, String lastName, String email, String username, String password, Integer confirmed) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmed = 0;
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

    public String getFirstName() {
        return this.firstName;
    }

}