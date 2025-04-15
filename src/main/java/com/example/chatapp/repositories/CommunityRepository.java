package com.example.chatapp.repositories;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.chatapp.models.*;

import jakarta.transaction.Transactional;

public interface CommunityRepository extends JpaRepository<Communities, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO community_tags_reltn (community_id, tag_Id) VALUES (:attribute1, :attribute2)", nativeQuery = true)
    void createCommunityTagReltn(@Param("attribute1") Long attribute1, @Param("attribute2") Long attribute2);

 }