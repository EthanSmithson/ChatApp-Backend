package com.example.chatapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatapp.repositories.*;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // public User createUser(User user) {
    //     return userRepository.save(user);
    // }

    // public List<User> getAllUsers() {
    //     return userRepository.findAll();
    // }

    // public List<User> CreateUser() {
    //     return userRepository.createUser();
    // }

}