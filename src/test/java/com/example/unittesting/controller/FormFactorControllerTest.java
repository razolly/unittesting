package com.example.unittesting.controller;

import com.example.unittesting.entity.FormFactor;
import com.example.unittesting.service.FormFactorService;
import com.example.unittesting.service.FormFactorServiceHardCoded;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormFactorController.class)
class FormFactorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FormFactorServiceHardCoded formFactorServiceHardCoded;

    @MockBean
    private FormFactorService formFactorService;

    @Test
    void getFormFactor_simple() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/form-factor")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":100,\"phoneNo\":99991111,\"userName\":\"John Doe\"}"));
    }

    /**
     * Simple example of mocking a response from a controller dependency
     * @throws Exception
     */
    @Test
    void getFormFactorFromServiceHardCoded_simple() throws Exception {
        when(formFactorServiceHardCoded.getAllHardCodedFormFactors()).thenReturn(
                Arrays.asList(new FormFactor(100, 11111111, "User1"),
                        new FormFactor(200, 22222222, "User2"))
        );
        mockMvc.perform(MockMvcRequestBuilders.get("/form-factor-from-service-hardcoded")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":100,\"phoneNo\":11111111,\"userName\":\"User1\"},{\"id\":200,\"phoneNo\":22222222,\"userName\":\"User2\"}]"));
    }
}