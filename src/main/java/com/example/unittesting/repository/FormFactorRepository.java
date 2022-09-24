package com.example.unittesting.repository;

import com.example.unittesting.entity.FormFactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFactorRepository extends JpaRepository<FormFactor, Integer> {
}
