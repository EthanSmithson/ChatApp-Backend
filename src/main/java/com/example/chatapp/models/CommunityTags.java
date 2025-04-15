package com.example.chatapp.models;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "CommunityTags")
public class CommunityTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagId;
    private String tagTitle;

    public CommunityTags(Long id, String tagId, String tagTitle) {
        this.id = id;
        this.tagId = tagId;
        this.tagTitle = tagTitle;
    }

}