package com.example.se2.share.exception;

public class InternalServerError extends RuntimeException{
    public InternalServerError(String message){
        super(message);
    }
}
