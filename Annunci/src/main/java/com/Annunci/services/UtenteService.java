package com.Annunci.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Annunci.dto.AnnuncioDto;
import com.Annunci.dto.UtenteDto;
import com.Annunci.models.Utente;
import com.Annunci.repositories.UtenteRepository;
@Service
public class UtenteService {
    
	@Autowired
	AnnuncioService annuncioService;

    @Autowired
	UtenteRepository repository;
	
	@Autowired
	ModelMapper mapper;


    public UtenteDto insert(UtenteDto utenteDto) {

		Utente utente = mapper.map(utenteDto, Utente.class);
		
		Utente newUtente;
		
		try {
			newUtente = repository.save(utente);			
		} catch (Exception e) {
			return null;
		}
		
		if(newUtente.getId() == null)
			return null;
		
		return mapper.map(newUtente, UtenteDto.class);
	}

	public UtenteDto findByUsernameAndPass(UtenteDto utenteDto) {
		
		if(utenteDto == null)
			return null;

		Utente user = repository.findByUsernameAndPass(utenteDto.getUsername(),utenteDto.getPass());
		
		if(user == null)
			return null;
		
		return mapper.map(user,UtenteDto.class);
	}

    public List<AnnuncioDto> findAnnunciUtente(UtenteDto utenteDto) {
        if(utenteDto == null)
			return null;

		Utente utente = repository.findByUsername(utenteDto.getUsername());
		
		if(utente == null)
			return null;

		List<AnnuncioDto> listaAnnunci = annuncioService.findAnnunciByUtente(utente);
	

		return listaAnnunci;
    }

	public AnnuncioDto saveAnnuncioUtente(UtenteDto utenteDto, AnnuncioDto annuncioDto) {
		if(utenteDto == null)
			return null;

		Utente utente = repository.findByUsername(utenteDto.getUsername());

		if(utente == null)
			return null;

		AnnuncioDto annuncioSalvato = annuncioService.saveAnnuncio(utente, annuncioDto);

		if(annuncioSalvato == null)
			return null;

		annuncioSalvato.getUtente().setPass(null);
		return annuncioSalvato;
	}

	public AnnuncioDto delateAnnuncioUtente(UtenteDto utenteDto, AnnuncioDto annuncioDto) {
		if(utenteDto == null)
			return null;

		Utente utente = repository.findByUsername(utenteDto.getUsername());

		if(utente == null)
			return null;

		AnnuncioDto annuncioRimosso= annuncioService.delateAnnuncio(utente, annuncioDto);
		
		if(annuncioRimosso == null)
			return null;

		annuncioRimosso.getUtente().setPass(null);
		
		return annuncioRimosso;
	}
}   
