package com.user.service;


import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private User user;
    @InjectMocks  // Creates the mock object of UserServiceImpl and injects into that is marked with @Mock annotation
    private UserServiceImpl userService;

    @BeforeEach   // This method execute before each JUnit test case within class
    public void setup() {
        user = User.builder()
                .userId(1)
                .firstName("Abhijeet")
                .lastName("Mavi")
                .age(23)
                .gender("male")
                .contactNumber(9876543210L)
                .email("abhijeet13@gmail.com")
                .password("pass@123")
                .weight(72)
                .state("Uttar Pradesh")
                .area("Near Meerut")
                .pinCode(250401)
                .bloodGroup("B-")
                .build();
    }

    @DisplayName("JUnit test for register user service")
    @Test
    public void givenUser_whenSaved_thenReturnUser() {

        BDDMockito.given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.empty());
        BDDMockito.given(userRepository.save(user)).willReturn(user);

        User savedUser = userService.registerUser(user);

        Assertions.assertThat(savedUser).isNotNull();
    }

    @DisplayName("JUnit test for get by email and password")
    @Test
    public void givenUser_whenFindByEmailAndPassword_thenReturnUser() throws UserNotFoundException {

        BDDMockito.given(userRepository.getByEmailAndPassword(user.getEmail(), user.getPassword())).willReturn(user);

        User receivedUser = userService.getByEmailAndPassword(user.getEmail(), user.getPassword());

        Assertions.assertThat(receivedUser).isNotNull();
    }

    @DisplayName("JUnit test for get by state and blood group")
    @Test
    public void givenUser_whenFindByStateAndBloodGroup_thenReturnUser() throws UserNotFoundException {

        User user1 = User.builder()
                .userId(1)
                .firstName("Abhijeet")
                .lastName("Mavi")
                .age(23)
                .gender("male")
                .contactNumber(9876543210L)
                .email("abhijeet13@gmail.com")
                .password("pass@123")
                .weight(72)
                .state("Uttar Pradesh")
                .area("Near Meerut")
                .pinCode(250401)
                .bloodGroup("B-")
                .build();

        BDDMockito.given(userRepository.getByStateAndBloodGroup(user.getState(), user.getBloodGroup())).willReturn(List.of(user, user1));

        List<User> receivedUser = userService.getByStateAndBloodGroup(user.getState(), user.getBloodGroup());

        Assertions.assertThat(receivedUser).isNotNull();
        Assertions.assertThat(receivedUser.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getting all users")
    @Test
    public void givenUsers_whenFindAllUsers_thenReturnUsersList() throws UserNotFoundException {

        User user1 = User.builder()
                .userId(1)
                .firstName("Abhijeet")
                .lastName("Mavi")
                .age(23)
                .gender("male")
                .contactNumber(9876543210L)
                .email("abhijeet13@gmail.com")
                .password("pass@123")
                .weight(72)
                .state("Uttar Pradesh")
                .area("Near Meerut")
                .pinCode(250401)
                .bloodGroup("B-")
                .build();

        BDDMockito.given(userRepository.findAll()).willReturn(List.of(user, user1));

        List<User> receivedUser = userService.getAllUsers();

        Assertions.assertThat(receivedUser).isNotNull();
        Assertions.assertThat(receivedUser.size()).isEqualTo(2);
    }
}
