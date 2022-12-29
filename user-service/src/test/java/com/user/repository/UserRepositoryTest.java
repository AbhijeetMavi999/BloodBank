package com.user.repository;

import com.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .firstName("Abhijeet")
                .lastName("Mavi")
                .age(22)
                .gender("male")
                .contactNumber(9876543210L)
                .email("abhijeet12@gmail.com")
                .password("abhijeet@123")
                .weight(70)
                .state("Uttar Pradesh")
                .area("Near Noida")
                .pinCode(315501)
                .bloodGroup("A+")
                .build();
    }

    @DisplayName("JUnit testing for save user operation")
    @Test
    public void givenUser_whenSave_thenReturnSavedUser() {

        // when - action or behaviour that we are going to test
        User savedUser = userRepository.save(user);

        // then - verify the output
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getUserId()).isGreaterThan(0);
    }


    @DisplayName("JUnit test of get all users operation")
    @Test
    public void givenUsers_whenFindAllUsers_thenReturnUsersList() {

        User user1 = new User();
        user1.setFirstName("Abhijeet");
        user1.setLastName("Mavi");
        user1.setAge(22);
        user1.setGender("male");
        user1.setContactNumber(9876543210L);
        user1.setEmail("abhijeetmavi123@gmail.com");
        user1.setPassword("password@123");
        user1.setWeight(70);
        user1.setState("Uttar Pradesh");
        user1.setArea("Meerut");
        user1.setPinCode(250410);
        user1.setBloodGroup("O+");

        userRepository.save(user);
        userRepository.save(user1);

        List<User> userList = userRepository.findAll();

        Assertions.assertThat(userList).isNotNull();
        Assertions.assertThat(userList.size()).isEqualTo(2);
    }


    @DisplayName("JUnit test for get user by email and password")
    @Test
    public void givenUser_whenFindByEmailAndPassword_thenReturnUser() {

        userRepository.save(user);

        User receivedUser = userRepository.getByEmailAndPassword(user.getEmail(), user.getPassword());

        Assertions.assertThat(receivedUser).isNotNull();
    }


    @DisplayName("JUnit test for get user by state and blood group")
    @Test
    public void givenUser_whenFindByStateAndBloodGroup_thenReturnUser() {

        userRepository.save(user);

        List<User> receivedUser = userRepository.getByStateAndBloodGroup(user.getState(), user.getBloodGroup());

        Assertions.assertThat(receivedUser).isNotNull();
    }
}
