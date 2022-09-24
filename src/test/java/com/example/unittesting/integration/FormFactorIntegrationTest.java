package com.example.unittesting.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

// Loads the whole application context, by looking for a class with @SpringBootConfiguration
// Usually finds the @SpringBootApplication class (with main method)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FormFactorIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {

    }
}
