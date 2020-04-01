package com.example.labday2.SpringRelationshipsFiles.controllers;



// @RestController is a specialized version of the controller. It includes the @Controller
// and @ResponseBody annotations and as a` result, simplifies the controller implementation:

import com.example.labday2.SpringRelationshipsFiles.models.Folder;
import com.example.labday2.SpringRelationshipsFiles.models.User;
import com.example.labday2.SpringRelationshipsFiles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
//        Create a new ResponseEntity with the given body and status code, and no headers.
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }




}
