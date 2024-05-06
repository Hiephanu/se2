package com.example.se2.share.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    };
}
