package com.example.chatapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chatapp.models.*;
import com.example.chatapp.utils.*;

public interface UserRepository extends JpaRepository<User, Long> {
   public String createUser(Person user) {
        return "User Created"
   }
}