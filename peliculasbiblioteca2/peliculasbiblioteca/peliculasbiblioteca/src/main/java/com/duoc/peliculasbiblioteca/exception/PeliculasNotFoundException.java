package com.duoc.peliculasbiblioteca.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PeliculasNotFoundException extends RuntimeException {
    public PeliculasNotFoundException(String message) {
        super(message);
    }
    
}
