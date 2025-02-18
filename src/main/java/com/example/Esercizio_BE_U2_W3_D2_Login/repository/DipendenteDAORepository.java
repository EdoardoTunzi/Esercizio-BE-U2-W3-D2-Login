package com.example.Esercizio_BE_U2_W3_D2_Login.repository;


import com.example.Esercizio_BE_U2_W3_D2_Login.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteDAORepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
