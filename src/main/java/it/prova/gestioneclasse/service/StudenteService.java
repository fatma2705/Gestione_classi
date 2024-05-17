package it.prova.gestioneclasse.service;

import java.util.List;

import it.prova.gestioneclasse.model.Studente;

public interface StudenteService {
	
	public List<Studente> listAllStudenti();
	
	public Studente caricoSingoloStudente(Long id);
	
	public void aggiorna(Studente studente);
	
	public void inserisciNuovo(Studente studente);
	
	public void rimuovi(Studente studente);
	
	public List<Studente> findByExample(Studente example);
	

}
