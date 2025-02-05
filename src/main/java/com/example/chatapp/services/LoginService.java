package com.example.chatapp.services;
import java.util.Map;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.chatapp.repositories.UserRepository;;

@Service
public class LoginService {

    @Autowired 
    private UserRepository userRepository;


    public Integer userExists(Map <String, String> data) {
        Integer loggedIn = userRepository.loginUser(data.get("username"), data.get("password"));

        if (loggedIn == null) {
            loggedIn = 2;
        }
        return loggedIn;
    }    
}