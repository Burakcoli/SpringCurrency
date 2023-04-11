package com.burakunutmaz.CurrencySpring.controllers;

import com.burakunutmaz.CurrencySpring.models.User;
import com.burakunutmaz.CurrencySpring.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody User user
    ){
        List<String> errorMessages = new ArrayList<>();
        if (user.getUsername().length() < 5){
            errorMessages.add("Username can not be shorter than 5 characters.");
        }
        if (user.getPassword().length() < 5){
            errorMessages.add("Password can not be shorter than 5 characters.");
        }

        if (!errorMessages.isEmpty()){
            return new ResponseEntity<>(errorMessages, HttpStatus.NOT_ACCEPTABLE);
        }

        if (userRepo.findByUsername(user.getUsername()) != null){
            return new ResponseEntity<>("Username already exists.",HttpStatus.NOT_ACCEPTABLE);
        } else {
            userRepo.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody User user
    ){
        List<String> errorMessages = new ArrayList<>();
        if (user.getUsername().length() < 5){
            errorMessages.add("Username can not be shorter than 5 characters.");
        }
        if (user.getPassword().length() < 5){
            errorMessages.add("Password can not be shorter than 5 characters.");
        }

        if (!errorMessages.isEmpty()){
            return new ResponseEntity<>(errorMessages, HttpStatus.NOT_ACCEPTABLE);
        }

        User foundUser = userRepo.findByUsername(user.getUsername());
        if (foundUser != null){
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Username not found.",HttpStatus.NOT_FOUND);
        }
    }
}
