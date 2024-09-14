package com.cenariar.formulario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenariar.formulario.Entity.Lead;
import com.cenariar.formulario.LeadNotFoundException.LeadNotFoundException;
import com.cenariar.formulario.Repository.LeadRepository;

@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead saveLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public List<Lead> getLeadsByName(String nome) {
        return leadRepository.findByName(nome); // Busca por nome exato
    }

     public List<Lead> getLeadsByPartialName(String partialName) {
        return leadRepository.findByNameContainingIgnoreCase(partialName);  // Busca por parte do nome
    }

    

    public Optional<Lead> getLeadById(Long id) {
        return leadRepository.findById(id)
                .or(() -> {
                    throw new LeadNotFoundException("Lead não encontrado com o id: " + id);
                });
    }

    public Optional<Lead> getLeadByEmail(String email) {
        return leadRepository.findByEmail(email);
    }

    public void deleteLead(Long id) {
        Optional<Lead> lead = leadRepository.findById(id);
        if (lead.isPresent()) {
            leadRepository.deleteById(id);
        } else {
            throw new LeadNotFoundException("Lead não encontrado com o id: " + id);
        }
    }
}
