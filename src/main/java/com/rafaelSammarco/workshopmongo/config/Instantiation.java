package com.rafaelSammarco.workshopmongo.config;

import com.rafaelSammarco.workshopmongo.domain.Post;
import com.rafaelSammarco.workshopmongo.domain.User;
import com.rafaelSammarco.workshopmongo.dto.AuthorDTO;
import com.rafaelSammarco.workshopmongo.dto.CommentDTO;
import com.rafaelSammarco.workshopmongo.repository.PostRepository;
import com.rafaelSammarco.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo, abraços!!", new AuthorDTO(maria));
        Post post1 = new Post(null, sdf.parse("23/03/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2023"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2023"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2023"), new AuthorDTO(alex));

        post.getCommentDTOS().addAll(Arrays.asList(c1, c2));
        post1.getCommentDTOS().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post, post1));

        maria.getPosts().addAll(Arrays.asList(post, post1));
        userRepository.save(maria);

    }
}
