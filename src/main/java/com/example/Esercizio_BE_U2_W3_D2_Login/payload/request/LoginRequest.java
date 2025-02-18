package com.example.Esercizio_BE_U2_W3_D2_Login.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message="Il campo username è obbligatorio")
    private String username;

    @NotBlank(message="Il campo password è obbligatorio")
    private String password;
}
