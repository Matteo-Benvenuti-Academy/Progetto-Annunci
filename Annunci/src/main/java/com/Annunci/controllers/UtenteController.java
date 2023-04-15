package com.Annunci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Annunci.dto.AnnuncioDto;
import com.Annunci.dto.UtenteDto;
import com.Annunci.models.Response;
import com.Annunci.services.UtenteService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("Annunci/utente")
@CrossOrigin("*")
public class UtenteController {
    
    @Autowired
    UtenteService service;

	@PostMapping("registrati")
	public Response insert(@RequestBody UtenteDto utente) {
		
		if( utente == null ||
            utente.getUsername() == null || utente.getUsername().isBlank() ||
            utente.getPass() == null || utente.getPass().isBlank() ||
            utente.getTelefono() == null || utente.getTelefono().isBlank() ||
            utente.getEmail() == null || utente.getEmail().isBlank())
			
			return new Response("ko");

		UtenteDto stu = service.insert(utente);
		
		if(stu == null)
			return new Response("ko");
		
		return new Response("ok",stu);
	}

	@PostMapping("/login")
	public Response login(@RequestBody UtenteDto user, HttpServletRequest request){
		
		UtenteDto loginUtente = service.findByUsernameAndPass(user);
		
		if(loginUtente == null)
			return new Response("ko");
		
		return new Response("ok",loginUtente);
	}


	@PostMapping("listaAnnunci")
	public Response findAnnunciUtente(@RequestBody UtenteDto utenteDto, HttpServletRequest request){

		UtenteDto utenteLogato = loginBySessionOrCredential(utenteDto,request);

		if(utenteLogato == null)
			return new Response("ko");

		List<AnnuncioDto> myAnnunci = service.findAnnunciUtente(utenteLogato);

		if (myAnnunci == null)
			return new Response("ko");
		
		return new Response("ok",myAnnunci);
	}

	@PostMapping("creaAnnuncio")
	public Response saveAnnuncioUtente(@RequestBody AnnuncioDto annuncioDto, HttpServletRequest request){

		UtenteDto utenteDto = annuncioDto.getUtente();

		UtenteDto utenteLogato = loginBySessionOrCredential(utenteDto,request);

		if(utenteLogato == null)
			return new Response("ko");

		AnnuncioDto annuncioSalvato = service.saveAnnuncioUtente( utenteLogato, annuncioDto);

		if (annuncioSalvato == null)
			return new Response("ko");

		return new Response("ok",annuncioSalvato);
	}

	@DeleteMapping("rimoviAnnuncio")
	public Response delateAnnuncioUtente(@RequestBody AnnuncioDto annuncioDto, HttpServletRequest request){

		UtenteDto utenteDto = annuncioDto.getUtente();

		UtenteDto utenteLogato = loginBySessionOrCredential(utenteDto,request);

		if(utenteLogato == null)
			return new Response("ko");

		AnnuncioDto annuncioRimosso = service.delateAnnuncioUtente( utenteLogato, annuncioDto);

		if (annuncioRimosso == null)
			return new Response("ko");

		return new Response("ok",annuncioRimosso);
	}

	private UtenteDto loginBySessionOrCredential(UtenteDto utenteDto,HttpServletRequest request){
		
		UtenteDto utenteCheck = service.findByUsernameAndPass(utenteDto);
		
		if(utenteCheck != null)
			return utenteCheck;

		return null;
	}
}
