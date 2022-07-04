package com.example.productmanagement.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
     @ExceptionHandler(value = NotFound.class)
     public ResponseEntity<ErrorMessage> handle(NotFound e){
        ErrorMessage errorMessage=new ErrorMessage("NOT_FOUND", e.getMessage());
        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setTimestamp(LocalDateTime.now());
     return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid  (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String>list= new ArrayList<>();
        for (ObjectError error: ex.getBindingResult().getAllErrors()){
            list.add(error.getDefaultMessage());
        }
        ErrorMessage errorMessage=new ErrorMessage("DATA_NOT_VALID", list );
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
}
