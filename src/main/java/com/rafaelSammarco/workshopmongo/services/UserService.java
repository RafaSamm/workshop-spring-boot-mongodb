package com.rafaelSammarco.workshopmongo.services;

import com.rafaelSammarco.workshopmongo.domain.User;
import com.rafaelSammarco.workshopmongo.repository.UserRepository;
import com.rafaelSammarco.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
    
}
