package com.example.unittesting.service;

import com.example.unittesting.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceWithMockTest {

    private UserService userService;

    @Test
    void addUserAge_fromRepo() {
        List<Integer> ages = new ArrayList<>();
        userService = new UserService();
        UserRepository repoMock = mock(UserRepository.class);
        userService.setUserRepository(repoMock);

        when(repoMock.getAllAges()).thenReturn(new ArrayList<>(Arrays.asList(1,2,3)));
        int totalAge = userService.addUserAgeFromRepo();

        int expected = 6;
        assertThat(totalAge).isEqualTo(expected);
    }

}