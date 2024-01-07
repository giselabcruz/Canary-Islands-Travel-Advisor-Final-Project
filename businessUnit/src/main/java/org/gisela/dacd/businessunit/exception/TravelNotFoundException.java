package org.gisela.dacd.businessunit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(String message) {
        super(message);
    }
}
