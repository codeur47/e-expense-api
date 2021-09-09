package com.yorosoft.eexpenseapi.controller;

import static org.mockito.Mockito.mock;

import com.yorosoft.eexpenseapi.repository.CategoryRepository;
import com.yorosoft.eexpenseapi.service.CategoryService;
import org.junit.jupiter.api.Test;

public class CategoryControllerTest {
    @Test
    public void testConstructor() {
        // TODO: This test is incomplete.
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     CrudController.service

        new CategoryController(new CategoryService(mock(CategoryRepository.class)));
    }
}

