package com.Annunci.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Annunci.dto.AnnuncioDto;
import com.Annunci.models.Response;
import com.Annunci.services.AnnuncioService;
import com.Annunci.utils.DataSorter;

@RestController
@RequestMapping("Annunci")
@CrossOrigin("*")
public class AnnuncioController {
    
    @Autowired
	AnnuncioService service;


    @GetMapping
    public Response findAll(){
        List<AnnuncioDto> annunci = DataSorter.sort(service.findAll());
		
		if(annunci==null)
			new Response("ko");
		
		return new Response("ok",annunci);  
    }
}
