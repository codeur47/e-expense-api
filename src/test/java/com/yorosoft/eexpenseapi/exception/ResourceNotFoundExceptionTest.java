package com.yorosoft.eexpenseapi.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {
    @Test
    void testConstructor() {
        ResourceNotFoundException actualResourceNotFoundException = new ResourceNotFoundException();
        assertNull(actualResourceNotFoundException.getCause());
        assertEquals("com.yorosoft.eexpenseapi.exception.ResourceNotFoundException: Could not find resource.",
                actualResourceNotFoundException.toString());
        assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
        assertEquals("Could not find resource.", actualResourceNotFoundException.getMessage());
        assertEquals("Could not find resource.", actualResourceNotFoundException.getLocalizedMessage());
    }

    @Test
    void testConstructor2() {
        ResourceNotFoundException actualResourceNotFoundException = new ResourceNotFoundException(123L);
        assertNull(actualResourceNotFoundException.getCause());
        assertEquals("com.yorosoft.eexpenseapi.exception.ResourceNotFoundException: Could not find resource 123.",
                actualResourceNotFoundException.toString());
        assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
        assertEquals("Could not find resource 123.", actualResourceNotFoundException.getMessage());
        assertEquals("Could not find resource 123.", actualResourceNotFoundException.getLocalizedMessage());
    }
}

