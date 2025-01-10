package com.example.chatapp.services;
import java.util.Map;

// Importing required classes
import org.springframework.stereotype.Service;

@Service
public class ContactMeService {

    public boolean sendEmail(Map<String, String> data) {
        String name = (String) data.get("name");
        String email = (String) data.get("email");
        String body = (String) data.get("body");
        
        return true;
    }
}