package com.example.Esercizio_BE_U2_W3_D2_Login.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiError {
    private String message;
    private HttpStatus status;
}
