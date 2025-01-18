package com.example.chatapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatapp.repositories.*;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Any;
import java.util.*;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private UserService userService;

    public Boolean passwordsMatch(Map<String, String> data) {
        String password = data.get("password");
        String confirmPassword = data.get("confirmPassword");

        if (password.equals(confirmPassword)) {
            return true;
        } else {
            return false;
        }

    }

}