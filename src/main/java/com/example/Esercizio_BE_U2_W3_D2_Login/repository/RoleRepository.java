package com.example.Esercizio_BE_U2_W3_D2_Login.repository;

import com.example.Esercizio_BE_U2_W3_D2_Login.model.ERole;
import com.example.Esercizio_BE_U2_W3_D2_Login.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
