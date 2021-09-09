package com.yorosoft.eexpenseapi.controller;

import static org.mockito.Mockito.mock;

import com.yorosoft.eexpenseapi.repository.PurchaseRepository;
import com.yorosoft.eexpenseapi.service.PurchaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseControllerTest {
    @Test
    void testConstructor() {
        // TODO: This test is incomplete.
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     CrudController.service

        new PurchaseController(new PurchaseService(mock(PurchaseRepository.class)));
        Assertions.assertTrue(true);
    }
}

