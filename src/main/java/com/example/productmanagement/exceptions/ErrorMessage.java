package com.example.productmanagement.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private String statusCode;
    private Object message;
    int status;
    LocalDateTime timestamp;

    public ErrorMessage(String statusCode, Object message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
