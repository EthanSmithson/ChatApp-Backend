package com.example.chatapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DynamicRegistrationBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.chatapp.services.*;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

	@Autowired
    private ContactMeService contactMeService;

	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/login")
		public Object login(@RequestBody Map<String, String> formData) {

            System.out.println(formData);
            
            return formData;
		}
}