package com.exam.swapi.exception;


import org.springframework.http.HttpStatus;
public class NotFoundException extends SwapiException {
    public NotFoundException (String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
