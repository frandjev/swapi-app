package com.exam.swapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public abstract class SwapiException extends RuntimeException{
    private final HttpStatus status;

    public SwapiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
