package com.cenariar.formulario.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String phone;
    private String email;
    private String mensagem;

   
    public Long getId() {
        return id;
    }

   
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public String getPhone() {
        return phone;
    }

   
    public void setPhone(String phone) {
        this.phone = phone;
    }

  
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }

   
    public String getMensagem() {
        return mensagem;
    }

  
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}