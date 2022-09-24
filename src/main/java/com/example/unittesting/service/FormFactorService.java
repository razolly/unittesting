package com.example.unittesting.service;

import com.example.unittesting.entity.FormFactor;
import com.example.unittesting.repository.FormFactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormFactorService {

    @Autowired
    private FormFactorRepository formFactorRepository;

    public List<FormFactor> getAllFormFactors() {
        return formFactorRepository.findAll();
    }

    public List<FormFactor> getAllFormFactorsWithProcessing() {
        List<FormFactor> allFormFactors = formFactorRepository.findAll();
        for (FormFactor ff : allFormFactors) {
            ff.setDetails(ff.getId() + ", "
                    + ff.getPhoneNo() + ", "
                    + ff.getUserName());
        }
        return allFormFactors;
    }
}
