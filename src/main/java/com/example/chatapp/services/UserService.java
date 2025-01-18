package com.example.chatapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatapp.repositories.*;
import java.util.List;
import com.example.chatapp.utils.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Person createUser(Person user) {
        String person = userRepository.createUser(user);
        return person;
    }

}