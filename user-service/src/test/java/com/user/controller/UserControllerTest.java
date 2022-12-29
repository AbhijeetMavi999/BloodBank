package com.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.User;
import com.user.service.UserService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest  // This annotation creates an application context that contains all the beans necessary for
            // testing a Spring web controller.
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean  // This annotation tells Spring to create a mock instance of UserService and add it to the
                // application context so that it's injected into EmployeeController.
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;

    @BeforeEach
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

    @DisplayName("JUnit test for register user controller")
    @Test
    public void givenUser_whenUserRegister_thenReturnUser() throws Exception {

        BDDMockito.given(userService.registerUser(ArgumentMatchers.any(User.class)))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",
                        CoreMatchers.is(user.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName",
                        CoreMatchers.is(user.getLastName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",
                        CoreMatchers.is(user.getEmail())));
    }

    @DisplayName("JUnit test for get by email and password")
    @Test
    public void givenUser_whenFindByEmailAndPassword_thenReturnUser() throws Exception {

        BDDMockito.given(userService.getByEmailAndPassword(user.getEmail(), user.getPassword())).willReturn(user);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/user/{email}/{password}",
                user.getEmail(), user.getPassword()));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",
                        CoreMatchers.is(user.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName",
                        CoreMatchers.is(user.getLastName())));
    }

    @DisplayName("JUnit test for get by state and blood group")
    @Test
    public void givenUser_whenFindByStateAndBloodGroup_thenReturnUser() throws Exception {

        BDDMockito.given(userService.getByStateAndBloodGroup(user.getState(), user.getPassword())).willReturn(List.of(user));

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/user/{state}/{bloodGroup}",
                user.getState(), user.getBloodGroup()));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }

    @DisplayName("JUnit test for get all users")
    @Test
    public void givenUsers_whenFindAllUsers_thenReturnUsers() throws Exception {

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(User.builder().firstName("Sagar").lastName("Mavi").age(35).gender("male")
                        .contactNumber(987654321L).email("sagar@gmail.com").password("pass@123")
                        .weight(77).state("Uttar Pradesh").area("Near Noida").pinCode(645343)
                        .bloodGroup("B+")
                .build());

        BDDMockito.given(userService.getAllUsers()).willReturn(userList);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/user/all"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()",
                        CoreMatchers.is(userList.size())));
    }
}
