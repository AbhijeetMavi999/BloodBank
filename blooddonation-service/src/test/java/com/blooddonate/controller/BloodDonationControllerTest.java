package com.blooddonate.controller;

import com.blooddonate.entity.BloodDonation;
import com.blooddonate.service.BloodDonationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class BloodDonationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BloodDonationService bloodDonationService;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("JUnit test for donateBlood() method of controller")
    @Test
    public void givenBlood_whenBloodDonated_thenReturnDonatedBlood() throws Exception {

        BloodDonation bloodDonation = BloodDonation.builder()
                .state("Uttar Pradesh")
                .area("NCR")
                .pinCode(567821)
                .bloodGroup("A-")
                .city("Ghaziabad")
                .hospitalName("Neutrima Hospital")
                .build();

        BDDMockito.given(bloodDonationService.donateBlood(ArgumentMatchers.any(BloodDonation.class)))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/donateblood/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bloodDonation)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bloodGroup",
                        CoreMatchers.is(bloodDonation.getBloodGroup())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city",
                        CoreMatchers.is(bloodDonation.getCity())));
    }
}
