package com.Hiagodev.StudentMongo.services;

import com.Hiagodev.StudentMongo.domain.User;
import com.Hiagodev.StudentMongo.dto.UserDTO;
import com.Hiagodev.StudentMongo.repository.UserRepository;
import com.Hiagodev.StudentMongo.services.exception.ObjectNotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findOne(id);
        if (user == null) {
            throw new ObjectNotException("Objeto não encontrado");
        }
        return user;
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public  void delete(String id){
        findById(id);
        repo.delete(id);
    }
    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
