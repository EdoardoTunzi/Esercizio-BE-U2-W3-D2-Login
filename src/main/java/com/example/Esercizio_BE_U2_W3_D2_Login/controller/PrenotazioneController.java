package com.example.Esercizio_BE_U2_W3_D2_Login.controller;

import com.example.ProgettoBE_U2_W2_D5_GestioneViaggiAziendali.dto.PrenotazioneDTO;
import com.example.ProgettoBE_U2_W2_D5_GestioneViaggiAziendali.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
    @Autowired
    PrenotazioneService prenotazioneService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Page<PrenotazioneDTO>> getAllPrenotazioni(Pageable page) {
        Page<PrenotazioneDTO> prenotazioni = prenotazioneService.getAllPrenotazioni(page);
        return new ResponseEntity<>(prenotazioni, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrenotazione(@PathVariable long id) {
        return new ResponseEntity<>(prenotazioneService.deletePrenotazione(id), HttpStatus.OK);
    }
}
