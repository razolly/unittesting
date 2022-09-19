package com.example.unittesting.service;

import com.example.unittesting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUserAge(List<Integer> ages) {
        int totalAge = 0;
        for (Integer eachAge: ages) {
            totalAge += eachAge;
        }
        return totalAge;
    }

    public int addUserAgeFromRepo() {
        int totalAge = 0;
        for (Integer eachAge: userRepository.getAllAges()) {
            totalAge += eachAge;
        }
        return totalAge;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
