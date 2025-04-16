package com.example.chatapp.services;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.example.chatapp.models.*;

import com.example.chatapp.repositories.CommunityRepository;

@Service
public class CommunityService {

    @Autowired 
    private CommunityRepository communityRepository;

    public Boolean createCommunity(Communities community) {
        communityRepository.save(community);
        
        System.out.println(community.getCommunityId());
        if (community.getCommunityId() > 0) {
            System.out.println(community.getCommunityTags());
            List<Long> myTags = community.getCommunityTags();
            for (int i=0; i < myTags.size(); i++) {
                communityRepository.createCommunityTagReltn(community.getCommunityId(), myTags.get(i));
            }
            List<Long> myMembers = community.getCommunityMembers();
            for (int i=0; i < myMembers.size(); i++) {
                communityRepository.createCommunityMemberReltn(community.getCommunityId(), myMembers.get(i));
            }
        }
        return true;
    }

}