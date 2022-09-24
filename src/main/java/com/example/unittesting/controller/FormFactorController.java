package com.example.unittesting.controller;

import com.example.unittesting.entity.FormFactor;
import com.example.unittesting.service.FormFactorService;
import com.example.unittesting.service.FormFactorServiceHardCoded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FormFactorController {

    @Autowired
    private FormFactorServiceHardCoded formFactorServiceHardCoded;

    @Autowired
    private FormFactorService formFactorService;

    @GetMapping(value = "/form-factor")
    public FormFactor getFormFactor() {
        return new FormFactor(100, 99991111, "John Doe");
    }

    @GetMapping(value = "/form-factor-from-service-hardcoded")
    public List<FormFactor> getFormFactorFromServiceHardCoded() {
        return formFactorServiceHardCoded.getAllHardCodedFormFactors();
    }

    @GetMapping(value = "/form-factor-from-service")
    public List<FormFactor> getFormFactorFromService() {
        return formFactorService.getAllFormFactors();
    }
}
