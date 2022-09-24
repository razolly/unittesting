package com.example.unittesting.service;

import com.example.unittesting.entity.FormFactor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FormFactorServiceHardCoded {

    public List<FormFactor> getAllHardCodedFormFactors() {
        return Arrays.asList(new FormFactor(1, 12341234, "John Doe"),
                new FormFactor(2, 99991111, "Mary Jane"));
    }
}
