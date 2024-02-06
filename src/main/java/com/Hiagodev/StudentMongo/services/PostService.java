package com.Hiagodev.StudentMongo.services;

import com.Hiagodev.StudentMongo.domain.Post;
import com.Hiagodev.StudentMongo.domain.User;
import com.Hiagodev.StudentMongo.dto.UserDTO;
import com.Hiagodev.StudentMongo.repository.PostRepository;
import com.Hiagodev.StudentMongo.repository.UserRepository;
import com.Hiagodev.StudentMongo.services.exception.ObjectNotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post user = repo.findOne(id);
        if (user == null) {
            throw new ObjectNotException("Objeto não encontrado");
        }
        return user;
    }
}