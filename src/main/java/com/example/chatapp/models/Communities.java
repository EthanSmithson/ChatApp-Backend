package com.example.chatapp.models;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Communities")
public class Communities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String communityTitle;
    private String communityDescription;
    private int communityPrivacy;
    private List<Long> communityTags;
    private List<Long> communityMembers;

    public Communities(Long id, String communityTitle, String communityDescription, int communityPrivacy, List<Long> communityTags, List<Long> communityMembers) {
        this.id = id;
        this.communityTitle = communityTitle;
        this.communityDescription = communityDescription;
        this.communityPrivacy = communityPrivacy;
        this.communityTags = communityTags;
        this.communityMembers = communityMembers;
    }

    public Long getCommunityId() {
        return this.id;
    }

    public List<Long> getCommunityTags() {
        return this.communityTags;
    }

    public List<Long> getCommunityMembers() {
        return this.communityMembers;
    }

}