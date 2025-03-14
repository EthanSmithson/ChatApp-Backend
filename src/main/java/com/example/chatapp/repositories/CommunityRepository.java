package com.example.chatapp.repositories;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.chatapp.models.*;

import jakarta.transaction.Transactional;

public interface CommunityRepository extends JpaRepository<Communities, Long> {
   
 }