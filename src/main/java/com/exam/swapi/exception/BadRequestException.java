package com.exam.swapi.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends SwapiException{

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
