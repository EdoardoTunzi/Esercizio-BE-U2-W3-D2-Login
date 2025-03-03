package com.example.Esercizio_BE_U2_W3_D2_Login.payload.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.Set;


@Data
public class DipendenteDTO {
    @NotNull(message = "Il campo username è obbligatorio")
    @NotBlank(message = "Il campo username non può essere vuoto")
    private String username;
    @NotNull(message = "Il campo nome è obbligatorio")
    @NotBlank(message = "Il campo nome non può essere vuoto")
    private String nome;
    @NotNull(message = "Il campo cognome è obbligatorio")
    @NotBlank(message = "Il campo cognome non può essere vuoto")
    private String cognome;
    @Email(message = "L'email inserita non è valida")
    private String email;
    @URL(message = "L'URL inserito non è valido")
    private String profilePic;

    private Set<String> ruoli;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
