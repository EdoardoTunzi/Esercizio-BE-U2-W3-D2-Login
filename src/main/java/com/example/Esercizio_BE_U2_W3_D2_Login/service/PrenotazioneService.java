package com.example.Esercizio_BE_U2_W3_D2_Login.service;



import com.example.Esercizio_BE_U2_W3_D2_Login.exceptions.NotFoundException;
import com.example.Esercizio_BE_U2_W3_D2_Login.model.Prenotazione;
import com.example.Esercizio_BE_U2_W3_D2_Login.payload.request.PrenotazioneDTO;
import com.example.Esercizio_BE_U2_W3_D2_Login.repository.PrenotazioneDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneDAORepository prenotazioneRepo;

    //Ho aggiunti solo dei metodi base per controllare rapidamente da Postman che fossero state create le prenotazioni

    public Page<PrenotazioneDTO> getAllPrenotazioni(Pageable page) {
        Page<Prenotazione> listaPrenotazioni = prenotazioneRepo.findAll(page);
        List<PrenotazioneDTO> listaDto = new ArrayList<>();

        for (Prenotazione prenotazione : listaPrenotazioni.getContent()) {
            PrenotazioneDTO dto = fromPrenotazioneToDTO(prenotazione);
            listaDto.add(dto);
        }
        Page<PrenotazioneDTO> listaPage = new PageImpl<>(listaDto);
        return listaPage;
    }

    public String deletePrenotazione(long id) {
        Optional<Prenotazione> prenotazioneTrovato = prenotazioneRepo.findById(id);
        if (prenotazioneTrovato.isPresent()){
            prenotazioneRepo.delete(prenotazioneTrovato.get());
            return "Prenotazione con id: " + id + " eliminato con successo!";
        } else {
            throw new NotFoundException("Errore nel delete! Nessuna prenotazione trovata con id: " + id);
        }

    }
    //travaso DTO
    public PrenotazioneDTO fromPrenotazioneToDTO(Prenotazione prenotazione) {
        PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
        prenotazioneDTO.setDipendente_id(prenotazione.getDipendente().getId());
        prenotazioneDTO.setViaggio_id(prenotazione.getViaggio().getId());
        prenotazioneDTO.setData(prenotazione.getData());
        prenotazioneDTO.setNotePreferenze(prenotazione.getNotePreferenze());
        return prenotazioneDTO;
    }

}
