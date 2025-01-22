package com.example.chatapp.controllers;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.*;

@RestController
public class ConfirmUserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/confirm")
    public void confirmUser(@RequestParam("email") String email) {
        userService.updateToConfirm(email);
    }

}