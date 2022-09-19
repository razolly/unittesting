package com.example.unittesting.service;

import java.util.List;

public class UserService {

    public int addUserAge(List<Integer> ages) {
        int totalAge = 0;
        for (Integer eachAge: ages) {
            totalAge += eachAge;
        }
        return totalAge;
    }
}
