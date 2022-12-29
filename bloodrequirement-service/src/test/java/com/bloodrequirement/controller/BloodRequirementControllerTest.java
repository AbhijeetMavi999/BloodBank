package com.bloodrequirement.controller;

import com.bloodrequirement.entity.BloodRequirement;
import com.bloodrequirement.service.BloodRequirementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebMvcTest
public class BloodRequirementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BloodRequirementService bloodRequirementService;

    @Autowired
    private ObjectMapper objectMapper;

    private BloodRequirement bloodRequirement;

    @BeforeEach
    public void setup() {
        bloodRequirement = BloodRequirement.builder()
                .state("Uttar Pradesh")
                .area("Ganga Nagar")
                .pinCode(235460)
                .bloodGroup("AB-")
                .build();
    }

    @DisplayName("JUnit test for save blood requirement of controller")
    @Test
    public void givenBloodRequirement_whenSaved_thenReturnBloodRequirement() throws Exception {

        BDDMockito.given(bloodRequirementService.saveBloodRequirement(ArgumentMatchers.any(BloodRequirement.class)))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/bloodrequirement/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bloodRequirement)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.area",
                        CoreMatchers.is(bloodRequirement.getArea())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bloodGroup",
                        CoreMatchers.is(bloodRequirement.getBloodGroup())));
    }

    @DisplayName("JUnit test for get all blood requirement of controller")
    @Test
    public void givenBloodRequirements_whenFindAll_thenReturnBloodRequirements() throws Exception {

        List<BloodRequirement> bloodRequirementList = new ArrayList<>();
        bloodRequirementList.add(bloodRequirement);
        bloodRequirementList.add(BloodRequirement.builder().state("Haryana").area("NCR").pinCode(202416)
                .bloodGroup("B+").build());

        BDDMockito.given(bloodRequirementService.getAllBloodRequirements()).willReturn(bloodRequirementList);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/bloodrequirement/all"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()",
                        CoreMatchers.is(bloodRequirementList.size())));
    }
}
