package com.example.chatapp.services;
import java.util.Map;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.chatapp.repositories.CommunityRepository;

@Service
public class CommunityService {

    @Autowired 
    private CommunityRepository communityRepository;

    public Boolean createCommunity(Object formData) {
        Boolean communityCreated = communityRepository.createCommunity(formData);
        return communityCreated;
    }

}