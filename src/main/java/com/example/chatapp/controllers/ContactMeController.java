package com.example.chatapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.chatapp.services.ContactMeService;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ContactMeController {

	@Autowired
    private ContactMeService contactMeService;

	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/contactMe")
		public Object ContactMe(@RequestBody Map<String, String> formData) {

			System.out.println(contactMeService.sendEmail(formData));
			
			return new ResponseEntity<>("Hello World!", HttpStatus.OK);
		}
}