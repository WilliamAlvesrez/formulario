package com.cenariar.formulario.Repository;

import com.cenariar.formulario.Entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    // Busca por nome exato
    List<Lead> findByName(String nome);

    // Busca por parte do nome
    List<Lead> findByNameContainingIgnoreCase(String nome);

    // Busca por email
    Optional<Lead> findByEmail(String email);
}
