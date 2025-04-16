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
    @Query(value = "INSERT INTO community_tags_reltn (community_id, tag_Id) VALUES (:communityId, :tagId)", nativeQuery = true)
    void createCommunityTagReltn(@Param("communityId") Long communityId, @Param("tagId") Long tagId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO community_member_reltn (community_id, user_id) VALUES (:communityId, :userId)", nativeQuery = true)
    void createCommunityMemberReltn(@Param("communityId") Long communityId, @Param("userId") Long userId);

 }