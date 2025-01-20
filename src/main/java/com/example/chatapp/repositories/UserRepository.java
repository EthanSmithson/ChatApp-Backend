package com.example.chatapp.repositories;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.chatapp.models.*;

public interface UserRepository extends JpaRepository<User, Long> {
   @Query("SELECT COUNT(*) FROM User u WHERE u.email = :email GROUP BY :email")
   Long findByEmail(@Param("email") String email);

   @Query("SELECT COUNT(*) FROM User u WHERE u.username = :username GROUP BY :username")
   Long findByUsername(@Param("username") String username);
   
 }