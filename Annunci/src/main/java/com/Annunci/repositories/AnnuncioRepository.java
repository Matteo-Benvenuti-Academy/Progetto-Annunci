package com.Annunci.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Annunci.models.Annuncio;
import com.Annunci.models.Utente;
@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio,Integer>{

    List<Annuncio> findByUtente(Utente user);

    Annuncio findByCodiceAndUtente(String codice, Utente utente);
    
}
