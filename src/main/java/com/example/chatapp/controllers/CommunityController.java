package com.example.chatapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.chatapp.services.CommunityService;
import com.example.chatapp.services.UserService;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.*;

@RestController
public class CommunityController {
    
    @Autowired
    private CommunityService communityService;

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/searchUser")
    public Object confirmUser(@RequestParam("user") String user) {
        System.out.println(user);

        List<Object> foundUsers = userService.getFullUser(user);
        System.out.println(foundUsers);

        if (foundUsers.size() > 0) {
            return ResponseEntity.ok(foundUsers);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No User Found!");
        }

    }

}