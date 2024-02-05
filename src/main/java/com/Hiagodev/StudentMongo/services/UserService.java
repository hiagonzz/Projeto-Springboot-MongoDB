package com.Hiagodev.StudentMongo.services;

import com.Hiagodev.StudentMongo.domain.User;
import com.Hiagodev.StudentMongo.repository.UserRepository;
import com.Hiagodev.StudentMongo.services.exception.ObjectNotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
    public  User findById(String id){
        User user = repo.findOne(id);
        if(user == null){
            throw  new ObjectNotException("Objeto não encontrado");
        }
        return user;
    }
}
