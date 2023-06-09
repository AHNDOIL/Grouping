package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.controller.AdminController;
import com.AHNDOIL.Grouping.entity.UserEntity;
import com.AHNDOIL.Grouping.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final UserRepository userRepository;


    public CustomUserDetailsService(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        final UserEntity userEntity = userRepository.findByUsername(username);
        return new User(username, userEntity.getPassword(), new ArrayList<>());
    }


}
