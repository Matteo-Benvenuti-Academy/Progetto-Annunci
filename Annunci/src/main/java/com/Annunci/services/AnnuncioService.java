package com.Annunci.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Annunci.dto.AnnuncioDto;
import com.Annunci.models.Annuncio;
import com.Annunci.models.Utente;
import com.Annunci.repositories.AnnuncioRepository;

@Service
public class AnnuncioService {

    @Autowired
	AnnuncioRepository repository;
	
	@Autowired
	ModelMapper mapper;

    public List<AnnuncioDto> findAll() {
		
		List<Annuncio> listaAnnunci = repository.findAll();
		
		if(listaAnnunci == null)
			return null;
		
		List<AnnuncioDto> listaAnnunciDto = new ArrayList<>();
		
		for(Annuncio annuncio : listaAnnunci){
			annuncio.getUtente().setPass(null);
			listaAnnunciDto.add(mapper.map(annuncio, AnnuncioDto.class));
		}
		
		return listaAnnunciDto;
	}

    protected List<AnnuncioDto> findAnnunciByUtente(Utente user) {
        
		List<Annuncio> listaAnnunci = repository.findByUtente(user);

		if(listaAnnunci == null)
			return null;
		
		List<AnnuncioDto> listaAnnunciDto = new ArrayList<>();
		
		for(Annuncio annuncio : listaAnnunci){
			annuncio.setUtente(null);
			listaAnnunciDto.add(mapper.map(annuncio, AnnuncioDto.class));
		}
		
		return listaAnnunciDto;

    }

    protected AnnuncioDto saveAnnuncio(Utente utente, AnnuncioDto annuncioDto) {
        
		Annuncio annuncio = mapper.map(annuncioDto, Annuncio.class);

		if( annuncio == null || 
			annuncio.getTitolo() == null || annuncio.getTitolo().isBlank() ||
			annuncio.getTesto() == null || annuncio.getTesto().isBlank())
			
			return null;

		annuncio.setCodice(UUID.randomUUID().toString());
		annuncio.setPublicazione(LocalDateTime.now());
		annuncio.setUtente(utente);

		Annuncio annuncioSalvato;

		try {
			annuncioSalvato = repository.save(annuncio);			
		} catch (Exception e) {
			return null;
		}
		
		if(annuncioSalvato.getId() == null)
			return null;
		
		return mapper.map(annuncioSalvato, AnnuncioDto.class);

    }

	public AnnuncioDto delateAnnuncio(Utente utente, AnnuncioDto annuncioDto) {
		
		Annuncio annuncio = repository.findByCodiceAndUtente(annuncioDto.getCodice(),utente);

		if (annuncio == null) 
			return null;

		try {
			repository.delete(annuncio);			
		} catch (Exception e) {
			return null;
		}

		return mapper.map(annuncio,AnnuncioDto.class);
	}

}
