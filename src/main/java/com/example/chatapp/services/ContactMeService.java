package com.example.chatapp.services;
import java.util.Map;

// Importing required classes
import org.springframework.stereotype.Service;

@Service
public class ContactMeService {

    public boolean sendEmail(Map<String, String> data) {
        String name = (String) formData.get("name");
        String email = (String) formData.get("email");
        String body = (String) formData.get("body");
        return true;
    }
}