package com.yorosoft.eexpenseapi.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Could not find user.");
    }
    public ResourceNotFoundException(Long id) {
        super("Could not find user " + id + ".");
    }
}
