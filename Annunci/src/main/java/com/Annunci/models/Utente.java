package com.Annunci.models;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utente")
public class Utente {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utenteID")
	private Integer id;

	@Column
	private String username;

	@Column
	private String pass;

	@Column
	private String email;

	@Column
	private String telefono;

    @OneToMany(mappedBy = "utente")
    private List<Annuncio> listaAnnunci = new ArrayList<>();


    public List<Annuncio> getListaAnnunci() {
        return listaAnnunci;
    }

    public void setListaAnnunci(List<Annuncio> listaAnnunci) {
        this.listaAnnunci = listaAnnunci;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
