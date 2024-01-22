package com.Hiagodev.StudentMongo.resources;

import com.Hiagodev.StudentMongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<User>> findAll() {
        User maria = new User("1", "Maria das dores", "Mariaestácomdor@gmail.com");
        User Alex = new User("2", "alex silva", "Alex@gmail");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, Alex));
        return ResponseEntity.ok().body(list);
    }

}
