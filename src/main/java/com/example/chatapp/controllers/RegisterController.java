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
import com.example.chatapp.utils.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {

	@Autowired
    private RegisterService registerService;
	private UserService userService;

	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/register")
		public Object register(@RequestBody Map<String, String> formData) {
			Boolean passwordMatch = registerService.passwordsMatch(formData);
			if (passwordMatch) {
				System.out.println("worked");
				Person person = new Person(formData.get("firstName"), formData.get("lastName"), formData.get("email"), formData.get("username"), formData.get("password"));
				userService.createUser(person);
			} else {
				System.out.print("wtf");
			}

            
            return formData;
		}
}