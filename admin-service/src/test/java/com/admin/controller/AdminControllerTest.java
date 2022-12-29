package com.admin.controller;

import com.admin.entity.Admin;
import com.admin.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("JUnit test for admin get by adminId and adminPassword controller")
    @Test
    public void givenUser_whenFindByAdminIdAndPassword_then() throws Exception {

        Admin admin = Admin.builder()
                .adminId("abhijeet")
                .adminPassword("pass@123")
                .build();

        BDDMockito.given(adminService.getByAdminIdAndAdminPassword(admin.getAdminId(), admin.getAdminPassword()))
                .willReturn(admin);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/admin/{adminId}/{adminPassword}",
                admin.getAdminId(), admin.getAdminPassword()));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.adminId",
                CoreMatchers.is(admin.getAdminId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.adminPassword",
                        CoreMatchers.is(admin.getAdminPassword())));
    }
}
