package com.example.techwebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LinkNotFound extends RuntimeException{
    public LinkNotFound(String message){
        super(message);
    }

}
