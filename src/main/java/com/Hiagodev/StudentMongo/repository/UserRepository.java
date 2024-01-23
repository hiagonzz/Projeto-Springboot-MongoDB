package com.Hiagodev.StudentMongo.repository;

import com.Hiagodev.StudentMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {



}
