package com.example.chatapp.models;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "CommunityTagsReltn")
public class CommunityTagsReltn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long communityId;
    private Long tagId;

    public CommunityTagsReltn(Long id, Long communityId, Long tagId) {
        this.id = id;
        this.communityId = communityId;
        this.tagId = tagId;
    }

}