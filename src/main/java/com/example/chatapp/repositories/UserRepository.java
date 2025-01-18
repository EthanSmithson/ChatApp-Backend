package com.example.chatapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chatapp.models.*;

public interface UserRepository extends JpaRepository<UserModel, Long> {
//    public String createUser() {
//         return "User Created"
//    }
}