package com.example.chatapp.controllers;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.chatapp.services.UserService;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.*;

@RestController
public class ConfirmUserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/confirm")
    public Object confirmUser(@RequestParam("email") String email) {
        ModelAndView modelAndView = new ModelAndView();
        Boolean updated = userService.updateToConfirm(email);
        if (updated) {
            // return ResponseEntity.ok("User Confirmed!");
            modelAndView.setViewName("confirmed");
            return modelAndView;
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not Found!");

    }

}