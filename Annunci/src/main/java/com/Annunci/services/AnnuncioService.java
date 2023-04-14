package com.Annunci.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Annunci.dto.AnnuncioDto;
import com.Annunci.models.Annuncio;
import com.Annunci.repositories.AnnuncioRepository;

@Service
public class AnnuncioService {

    @Autowired
	AnnuncioRepository repository;
	
	@Autowired
	ModelMapper mapper;

    public List<AnnuncioDto> findAll() {
		
		List<Annuncio> listStu = repository.findAll();
		
		if(listStu == null)
			return null;
		
		List<AnnuncioDto> listStuDto = new ArrayList<>();
		
		
		for(Annuncio stu : listStu)
			listStuDto.add(mapper.map(stu, AnnuncioDto.class));
		
		return listStuDto;
	}

}
