package com.example.chatapp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.boot.web.servlet.DynamicRegistrationBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;

import com.example.chatapp.models.User;
import com.example.chatapp.repositories.UserRepository;
import com.example.chatapp.services.*;

import jakarta.mail.MessagingException;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.example.chatapp.dto.MailRequest;
import com.example.chatapp.models.*;

@RestController
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistrationService registrationService;

	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/register")
		public Object register(@RequestBody User formData) throws MessagingException {
			System.out.println(formData);
			if (userService.findUserEmail(formData) != null || userService.findUserUsername(formData) != null) {
				return ResponseEntity.badRequest().body("This Email or username is Already in Use");
			} else {
				if (userService.createUser(formData)) {
					MailRequest confirmEmail = new MailRequest();
					confirmEmail.setToEmail(formData.getUserEmail());
					confirmEmail.setSubject("Please Confirm Your email");
					confirmEmail.setMessage(formData.getUserEmail());
					confirmEmail.setHTML(true);
					Boolean confirmationSent = registrationService.sendConfirmMail(confirmEmail);
					System.out.println(confirmationSent);
					// registrationService.sendConfirmarion();
				}

				return new ResponseEntity<>("User Has Been Created", HttpStatus.OK);
			}
		}
}