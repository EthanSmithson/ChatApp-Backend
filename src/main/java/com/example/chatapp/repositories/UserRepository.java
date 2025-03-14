package com.example.chatapp.repositories;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.chatapp.models.*;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
   @Query("SELECT COUNT(*) FROM User u WHERE u.email = :email GROUP BY :email")
   Long findByEmail(@Param("email") String email);

   @Query("SELECT COUNT(*) FROM User u WHERE u.username = :username GROUP BY :username")
   Long findByUsername(@Param("username") String username);

   @Modifying
   @Transactional
   @Query("UPDATE User SET confirmed = 1 WHERE email = :email")
   void updateToConfirm(@Param("email") String email);

   @Query("SELECT COUNT(*) FROM User u WHERE (u.username = :userName OR u.email = :userName) AND (u.password = :password) GROUP BY :userName")
   Integer loginUser(@Param("userName") String userName, @Param("password") String password);

   @Query("SELECT username FROM User u WHERE u.username LIKE %:user%")
   List<Object> getFullUsers(@Param("user") String user);
   
 }