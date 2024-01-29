package com.api.flightreservation.controllers;

import com.api.flightreservation.entities.LoginDetails;
import com.api.flightreservation.entities.User;
import com.api.flightreservation.services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @PostMapping("/registerUser")
    public ResponseEntity<User> register( @Valid @RequestBody User user){
        LOGGER.info("Inside Registration Method");
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDetails loginDetails){
        LOGGER.info("Inside the registration method");
        return new ResponseEntity<String>(userService.getUserDetails(loginDetails),HttpStatus.OK);
    }
}
