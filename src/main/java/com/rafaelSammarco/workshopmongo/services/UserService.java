package com.rafaelSammarco.workshopmongo.services;

import com.rafaelSammarco.workshopmongo.domain.User;
import com.rafaelSammarco.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
