package com.Hiagodev.StudentMongo.config;

import com.Hiagodev.StudentMongo.domain.Post;
import com.Hiagodev.StudentMongo.domain.User;
import com.Hiagodev.StudentMongo.dto.AuthorDTO;
import com.Hiagodev.StudentMongo.dto.CommentDTO;
import com.Hiagodev.StudentMongo.repository.PostRepository;
import com.Hiagodev.StudentMongo.repository.UserRepository;
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

        Post post1 = new Post(null, sdf.parse("18/10/1998"), "Partiu viagem", "Vou viajar para são paulo Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("20/2/2021"), "bom dia", "Acordei feliz hoje", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("20/10/2021"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("18/10/1998"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Valew meu amado", sdf.parse("14/10/2000"), new AuthorDTO(bob));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
