package com.example.unittesting.integration;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

// Loads the whole application context, by looking for a class with @SpringBootConfiguration
// Usually finds the @SpringBootApplication class (with main method)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FormFactorIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        ResponseEntity<String> response = restTemplate.getForEntity("/form-factor-from-service-processed", String.class);
        JSONAssert.assertEquals("[{id:100},{id:101},{id:102}]", response.getBody(), false);
    }
}
