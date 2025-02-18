package com.example.Esercizio_BE_U2_W3_D2_Login.security.services;

import com.example.Esercizio_BE_U2_W3_D2_Login.model.Dipendente;
import com.example.Esercizio_BE_U2_W3_D2_Login.repository.DipendenteDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DipendenteDetailsServiceImpl implements UserDetailsService {
  @Autowired
  DipendenteDAORepository dipendenteRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Dipendente dipendente = dipendenteRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return DipendenteDetailsImpl.build(dipendente);
  }

}
