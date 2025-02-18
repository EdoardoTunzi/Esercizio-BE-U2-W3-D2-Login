package com.example.Esercizio_BE_U2_W3_D2_Login.payload.request;


import com.example.Esercizio_BE_U2_W3_D2_Login.model.Dipendente;
import com.example.Esercizio_BE_U2_W3_D2_Login.model.StatoViaggio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioDTO {
    @NotNull(message = "Il campo destinazione è obbligatorio")
    @NotBlank(message = "Il campo destinazione non può essere vuoto")
    @Size(min = 3, max = 15, message = "Il nome della destinazione deve essere lungo minimo 4 e massimo 15 caratteri")
    private String destinazione;

    @NotNull(message = "Il campo data è obbligatorio")
    private LocalDate data;

    @NotNull(message = "Il campo stato è obbligatorio")
    private StatoViaggio stato;

    private Dipendente dipendente;
}
