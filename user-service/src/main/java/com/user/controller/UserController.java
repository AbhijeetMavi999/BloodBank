package com.user.controller;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        log.info("registerUser() method of UserController is called");
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<User> getByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) throws UserNotFoundException {
        log.info("getByEmailAndPassword() method of UserController is called");
        User receiveUser = userService.getByEmailAndPassword(email, password);
        return new ResponseEntity<>(receiveUser, HttpStatus.OK);
    }

    @GetMapping("/checkblood/{state}/{bloodGroup}")
    public ResponseEntity<List<User>> getByStateAndBloodGroup(@PathVariable("state") String state, @PathVariable("bloodGroup") String bloodGroup) {
        log.info("getByStateAndBloodGroup() method of UserController is called");
        List<User> users = userService.getByStateAndBloodGroup(state, bloodGroup);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("getAllUsers() method of UserController is called");
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
