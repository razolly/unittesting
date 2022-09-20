package com.example.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormFactorController.class)
class FormFactorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFormFactor_simple() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/form-factor")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":100,\"phoneNo\":99991111,\"userName\":\"John Doe\"}"));

    }
}