package com.rafaelSammarco.workshopmongo.services;

import com.rafaelSammarco.workshopmongo.domain.Post;
import com.rafaelSammarco.workshopmongo.domain.User;
import com.rafaelSammarco.workshopmongo.dto.UserDTO;
import com.rafaelSammarco.workshopmongo.repository.PostRepository;
import com.rafaelSammarco.workshopmongo.repository.UserRepository;
import com.rafaelSammarco.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }


}
