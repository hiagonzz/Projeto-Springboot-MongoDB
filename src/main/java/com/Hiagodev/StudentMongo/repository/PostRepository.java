package com.Hiagodev.StudentMongo.repository;

import com.Hiagodev.StudentMongo.domain.Post;
import com.Hiagodev.StudentMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContaningIgnoreCase(String text);


}
