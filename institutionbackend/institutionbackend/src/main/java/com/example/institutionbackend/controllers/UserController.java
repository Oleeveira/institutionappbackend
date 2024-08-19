package com.example.institutionbackend.controllers;

import com.example.institutionbackend.models.User;
import com.example.institutionbackend.repositories.UserRepository;
import com.example.institutionbackend.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Data
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucessful");
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User newUser) throws InterruptedException, ExecutionException {

        return userService.createUser(newUser);
    }

    @GetMapping("/get/id")
    public ResponseEntity getUser(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<User> user = userRepository.findById(id);
        userService.getUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update/id")
    public ResponseEntity updateUser(@PathVariable Long id) throws InterruptedException, ExecutionException {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity deleteUser(@PathVariable Long id) throws InterruptedException, ExecutionException {

        return ResponseEntity.ok().build();
    }



}
