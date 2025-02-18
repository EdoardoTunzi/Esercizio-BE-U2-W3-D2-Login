package com.example.Esercizio_BE_U2_W3_D2_Login.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}