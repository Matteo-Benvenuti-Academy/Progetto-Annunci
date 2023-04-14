package com.Annunci.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Annunci.models.Annuncio;
@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio,Integer>{
    
}
