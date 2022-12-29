package com.user.service.impl;

import com.user.entity.User;
import com.user.exception.UserAlreadyExistException;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // For JUnit test of Service Layer
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        log.info("registerUser() method of UserService is called");
        Optional<User> isPresent = userRepository.findByEmail(user.getEmail());
        if(!isPresent.isEmpty()) {
            log.warn("User with email "+user.getEmail()+" already exist");
            throw new UserAlreadyExistException("User already present");
        }
        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) throws UserNotFoundException {
        log.info("getByEmailAndPassword() method of UserService is called");
        User receiveUser = userRepository.getByEmailAndPassword(email, password);
        if(receiveUser == null) {
            log.warn("User not found");
            throw new UserNotFoundException("User not found!");
        }
        return receiveUser;
    }

    @Override
    public List<User> getByStateAndBloodGroup(String state, String bloodGroup) {
        log.info("getByStateAndPinCodeAndBloodGroup() method of UserService is called");
        List<User> users = userRepository.getByStateAndBloodGroup(state, bloodGroup);
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("getAllUsers() method of UserService is called");
        List<User> users = userRepository.findAll();
        return users;
    }
}
