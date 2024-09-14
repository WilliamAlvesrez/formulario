package com.cenariar.formulario.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenariar.formulario.Entity.Lead;
import com.cenariar.formulario.Service.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @Autowired
    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        Lead savedLead = leadService.saveLead(lead);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLead); // Retorna status 201
    }

    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        return leadService.getLeadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        Optional<Lead> lead = leadService.getLeadById(id); 
        if (!lead.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @RequestBody Lead lead) {
        return leadService.getLeadById(id)
                .map(existingLead -> {
                    lead.setId(existingLead.getId());
                    return ResponseEntity.ok(leadService.saveLead(lead));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Lead>> getLeadsByName(@PathVariable String nome) {
        return ResponseEntity.ok(leadService.getLeadsByName(nome));
    }
    
    @GetMapping("/nome-parcial/{nome}")
    public ResponseEntity<List<Lead>> getLeadsByPartialName(@PathVariable String nome) {
        return ResponseEntity.ok(leadService.getLeadsByPartialName(nome));
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Lead> getLeadByEmail(@PathVariable String email) {
        return leadService.getLeadByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    


}
