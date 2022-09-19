package com.example.unittesting.service;

import com.example.unittesting.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestWithArgumentMatchers {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void test_addUserAgeFromArgs_matcherSimple() {
//        when(userService.addUserAgeFromArgs(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(100);
//        when(userService.addUserAgeFromArgs(1,2,3,4)).thenReturn(100);
        assertThat(userService.addUserAgeFromArgs(1,2,3,4)).isEqualTo(10);
    }
}
