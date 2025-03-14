package com.example.chatapp.services;
import java.util.Map;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.chatapp.repositories.CommunityRepository;

@Service
public class CommunityService {

    @Autowired 
    private CommunityRepository communityRepository;

}