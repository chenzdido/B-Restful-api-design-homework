package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class teamNameExists extends RuntimeException {
    public teamNameExists(String message) {
        super(message);
    }
}
