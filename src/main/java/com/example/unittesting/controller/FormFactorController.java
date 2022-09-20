package com.example.unittesting.controller;

import com.example.unittesting.entity.FormFactor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormFactorController {

    @GetMapping(value = "/form-factor")
    public FormFactor getFormFactor() {
        return new FormFactor(100, 99991111, "John Doe");
    }
}
