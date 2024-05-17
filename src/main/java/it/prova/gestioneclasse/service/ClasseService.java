package it.prova.gestioneclasse.service;

import java.util.List;

import it.prova.gestioneclasse.model.Classe;

public interface ClasseService {

	public List<Classe> listAllClassi();

	public Classe caricaSingolaClasse(Long id);

	public void aggiorna(Classe classe);

	public void inserisciNuovo(Classe classe);

	public void rimuovi(Classe classe);

	public List<Classe> findByExample(Classe example);
}
