package it.prova.gestioneclasse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import it.prova.gestioneclasse.model.Studente;
import it.prova.gestioneclasse.repository.StudenteRepository;
import jakarta.persistence.EntityManager;

@Service
public class StudenteServiceImpl implements StudenteService {

	@Autowired
	private StudenteRepository studenteRepository;
	@Autowired
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<Studente> listAllStudenti() {
		return (List<Studente>) studenteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Studente caricoSingoloStudente(Long id) {
		return studenteRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Studente studente) {
		studenteRepository.save(studente);

	}

	@Transactional
	public void inserisciNuovo(Studente studente) {
		studenteRepository.save(studente);

	}

	@Transactional
	public void rimuovi(Studente studente) {
		studenteRepository.delete(studente);
	}

	@Transactional(readOnly = true)
	public List<Studente> findByExample(Studente example) {

		String query = "select s from Studente s where s.id=s.id";

		if (!(ObjectUtils.isEmpty(example.getMatricola())))
			query += " and s.matricola like '%" + example.getMatricola() + "%'";
		if (!(ObjectUtils.isEmpty(example.getMatricola())))
			query += " and s.nome like '%" + example.getNome() + "%'";
		if (!(ObjectUtils.isEmpty(example.getCognome())))
			query += " and s.cognome like '%" + example.getCognome() + "%'";
		if (example.getDataNascita() != null)
			query += " and s.data_nascita = " + example.getDataNascita();
		return entityManager.createQuery(query, Studente.class).getResultList();
	}

}
