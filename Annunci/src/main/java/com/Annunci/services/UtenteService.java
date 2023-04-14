package com.Annunci.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Annunci.dto.UtenteDto;
import com.Annunci.models.Utente;
import com.Annunci.repositories.UtenteRepository;
@Service
public class UtenteService {
    
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
		
		Utente user = repository.findByUsernameAndPass(utenteDto.getUsername(),utenteDto.getPass());
		
		if(user == null)
			return null;
		
		return mapper.map(user,UtenteDto.class);
	}

	

}   
