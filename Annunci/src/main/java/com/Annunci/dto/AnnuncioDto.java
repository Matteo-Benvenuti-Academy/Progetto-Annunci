package com.Annunci.dto;

import java.time.LocalDateTime;

public class AnnuncioDto {
    
    private String codice;
    
	private String titolo;

	private String testo;

	private LocalDateTime publicazione;

    private UtenteDto utente;

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

    public UtenteDto getUtente() {
        return utente;
    }

    public void setUtente(UtenteDto utente) {
        this.utente = utente;
    }
}
