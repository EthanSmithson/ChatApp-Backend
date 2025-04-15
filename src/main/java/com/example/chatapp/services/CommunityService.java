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
    // private Map<Long, Long> tagReltns = new HashMap<Long, Long>();

    public Boolean createCommunity(Communities community) {
        communityRepository.save(community);
        
        System.out.println(community.getCommunityId());
        if (community.getCommunityId() > 0) {
            System.out.println(community.getCommunityTags());
            List<Long> myTags = community.getCommunityTags();
            for (int i=0; i < myTags.size(); i++) {
                // tagReltns.put(community.getCommunityId(), myTags.get(i));
                communityRepository.createCommunityTagReltn(community.getCommunityId(), myTags.get(i));
            }
            // System.out.println(tagReltns);
        }
        return true;
    }

}