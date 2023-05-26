package com.rafaelSammarco.workshopmongo.repository;

import com.rafaelSammarco.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
