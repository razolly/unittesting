package com.example.unittesting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FormFactorRepositoryTest {

    @Autowired
    private FormFactorRepository repository;

    @Test
    public void findAll() {
        assertThat(repository.findAll().size()).isEqualTo(3);
    }
}