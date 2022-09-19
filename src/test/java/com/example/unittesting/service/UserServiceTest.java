package com.example.unittesting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void addUserAge_positive() {
        userService = new UserService();
        List<Integer> ages = new ArrayList<>(Arrays.asList(20, 21, 22));

        int totalAge = userService.addUserAge(ages);

        int expected = 63;
        assertThat(totalAge).isEqualTo(expected);
    }

    @Test
    void addUserAge_empty() {
        userService = new UserService();

        List<Integer> ages = new ArrayList<>();

        int totalAge = userService.addUserAge(ages);

        int expected = 0;
        assertThat(totalAge).isEqualTo(expected);
    }

}