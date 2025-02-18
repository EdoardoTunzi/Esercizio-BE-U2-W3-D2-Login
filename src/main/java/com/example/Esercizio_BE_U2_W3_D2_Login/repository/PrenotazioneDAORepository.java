package com.example.Esercizio_BE_U2_W3_D2_Login.repository;


import com.example.Esercizio_BE_U2_W3_D2_Login.model.Dipendente;
import com.example.Esercizio_BE_U2_W3_D2_Login.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneDAORepository extends JpaRepository<Prenotazione,Long> {
    List<Prenotazione> findByDataAndDipendente(LocalDate data, Dipendente dipendente);
    List<Prenotazione> findByDipendente(Dipendente dipendente);
}

