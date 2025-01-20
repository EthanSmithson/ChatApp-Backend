package com.example.chatapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

@Service
public class RegistrationService {

    @Autowired
    private JavaMailSender mailSender;
    
    public static Boolean sendConfirmation(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom("chatapp.com");
        message.setSubject("Please Confirm Your Account");
        message.setText("Confirm");
        
        mailSender.send(message);
    
        return true;
    }
}