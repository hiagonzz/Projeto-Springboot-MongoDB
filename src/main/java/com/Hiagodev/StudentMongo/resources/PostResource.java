package com.Hiagodev.StudentMongo.resources;


import com.Hiagodev.StudentMongo.domain.Post;
import com.Hiagodev.StudentMongo.domain.User;
import com.Hiagodev.StudentMongo.dto.UserDTO;
import com.Hiagodev.StudentMongo.resources.util.URL;
import com.Hiagodev.StudentMongo.services.PostService;
import com.Hiagodev.StudentMongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/posts")
public class PostResource {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {
       text = URL.decodeParam(text);
       List<Post> list = service.findByTitle(text);


        return ResponseEntity.ok().body(list);
    }

    @Autowired
    private PostService service;

}
