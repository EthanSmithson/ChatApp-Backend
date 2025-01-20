package com.example.chatapp.services;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactMeService {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(Map<String, String> data) {
        SimpleMailMessage message = new SimpleMailMessage();
        String name = (String) data.get("name");
        String email = (String) data.get("email");
        String body = (String) data.get("body");
        message.setTo("ethansmithson413@gmail.com");
        message.setFrom(email);
        message.setSubject(name);
        message.setText(body);
        
        mailSender.send(message);

        return true;
    }

    public Map<String, Boolean> validate(Map<String, String> data) {
        String name = (String) data.get("name");
        String email = (String) data.get("email");
        String body = (String) data.get("body");
        Boolean nameBad = true;
        Boolean emailBad = true;
        Boolean bodyBad = true;
        if (name == null) {
            nameBad = false;
        }
        if (!isValidEmail(email)) {
            emailBad = false;
        }
        if (body == null) {
            bodyBad = false;
        }

        Map<String, Boolean> validate = new Hashtable<>();
        validate.put("nameValid", nameBad);
        validate.put("emailValid", emailBad);
        validate.put("bodyValid", bodyBad);

        return validate;
    }

    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}