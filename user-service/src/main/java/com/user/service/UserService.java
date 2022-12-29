package com.user.service;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User registerUser(User user);

    public User getByEmailAndPassword(String email, String password) throws UserNotFoundException;

    public List<User> getByStateAndBloodGroup(String state, String bloodGroup);

    List<User> getAllUsers();
}
