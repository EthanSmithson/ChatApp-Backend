package com.example.chatapp.models;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Communities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String communityTitle;
    private String communityDescription;
    private int communityPrivacy;
    private List<String> communityTags;

    public Communities(Long id, String communityTitle, String communityDescription, int communityPrivacy, List<String> communityTags) {
        this.id = id;
        this.communityTitle = communityTitle;
        this.communityDescription = communityDescription;
        this.communityPrivacy = communityPrivacy;
        this.communityTags = communityTags;
    }

}