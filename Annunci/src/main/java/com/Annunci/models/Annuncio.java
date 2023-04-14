package com.Annunci.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Annuncio")
public class Annuncio {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "annuncioID")
	private Integer id;

	@Column
	private String codice;
    
	@Column
	private String titolo;

	@Column
	private String testo;

	@Column
	private LocalDateTime publicazione;

    @ManyToOne
    @JoinColumn(name = "utenteRIF")
    Utente utente;

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public LocalDateTime getPublicazione() {
        return publicazione;
    }

    public void setPublicazione(LocalDateTime publicazione) {
        this.publicazione = publicazione;
    }
    
}
