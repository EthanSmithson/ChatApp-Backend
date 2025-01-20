package com.example.chatapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Service;
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

}