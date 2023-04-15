package com.Annunci.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Annunci.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente,Integer>{
    
    public Utente findByUsernameAndPass(String username , String pass);

    public Utente findByUsername(String username);
}
