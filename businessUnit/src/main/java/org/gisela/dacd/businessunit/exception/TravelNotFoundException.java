package org.gisela.dacd.businessunit.exception;

public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(String message) {
        super(message);
    }
}
