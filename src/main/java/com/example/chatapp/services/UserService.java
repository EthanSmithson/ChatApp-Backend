package com.example.chatapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.chatapp.repositories.*;
import java.util.*;
import com.example.chatapp.models.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactMeService contactMeService;

    public Boolean createUser(User user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (contactMeService.isValidEmail(user.getUserEmail())) {
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    public Long findUserEmail(User user) {
        Long userData = userRepository.findByEmail(user.getUserEmail());
        return userData;
    }

    public Long findUserUsername(User user) {
        Long userData = userRepository.findByUsername(user.getUserUsername());
        return userData;
    }

    public boolean sendConfirmation(User user) {

        return true;
    }

    public Boolean updateToConfirm(String email) {
        Long emailExists = userRepository.findByEmail(email);
        System.out.println(emailExists);
        
        if (emailExists != 1) {
            throw new IllegalArgumentException("Email was not Found!");
        }

        userRepository.updateToConfirm(email);
        return true;

    }

    public List<Object> getFullUser(String user) {
        return userRepository.getFullUsers(user);
    }

}