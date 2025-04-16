package com.example.chatapp.models;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "CommunityMemberReltn")
public class CommunityMemberReltn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String communityId;

    public CommunityMemberReltn(Long id, Long userId, String communityId) {
        this.id = id;
        this.userId = userId;
        this.communityId = communityId;
    }

}