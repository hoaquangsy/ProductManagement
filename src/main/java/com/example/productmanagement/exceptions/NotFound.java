package com.example.productmanagement.exceptions;

public class NotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public NotFound(String mess){
        super(mess);
    }
}
