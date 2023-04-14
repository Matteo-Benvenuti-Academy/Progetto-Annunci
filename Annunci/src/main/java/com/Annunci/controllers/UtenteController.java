package com.Annunci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("signUp")
	public Response insert(@RequestBody UtenteDto utente) {
		
		if( utente == null ||
            utente.getUsername().isBlank() ||
            utente.getPass().isBlank() ||
            utente.getTelefono().isBlank() ||
            utente.getEmail().isBlank())
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
		
		request.getSession().setAttribute("logUser", loginUtente);
		
		return new Response("ok",loginUtente);
	}


	// @GetMapping("listaAnnunci")
	// public Response findMyAnnunci(@RequestBody UtenteDto utente, HttpServletRequest request){
	// 	UtenteDto utenteDto = (UtenteDto) request.getSession();

	// 	if(utente == null)
	// 		return new Response("ko");

	// 	List<AnnuncioDto> myAnnunci = service.findMyAnnunci();

	// 	if (myAnnunci == null)
	// 		return new Response("ko");
		
	// 	return new Response("ko",myAnnunci);
	// }

}
