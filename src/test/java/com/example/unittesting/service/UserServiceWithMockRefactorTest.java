package com.example.unittesting.service;

import com.example.unittesting.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceWithMockRefactorTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void addUserAge_fromRepo() {
        when(userRepository.getAllAges()).thenReturn(new ArrayList<>(Arrays.asList(1,2,3)));
        int totalAge = userService.addUserAgeFromRepo();
        assertThat(totalAge).isEqualTo(6);
    }

}