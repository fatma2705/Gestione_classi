package it.prova.gestioneclasse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import it.prova.gestioneclasse.model.Classe;
import it.prova.gestioneclasse.repository.ClasseRepository;
import jakarta.persistence.EntityManager;

@Service
public class ClasseServiceImpl implements ClasseService {

	@Autowired
	private ClasseRepository classeRipository;
	@Autowired
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<Classe> listAllClassi() {
		return (List<Classe>) classeRipository.findAll();
	}

	@Transactional(readOnly = true)
	public Classe caricaSingolaClasse(Long id) {
		return classeRipository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Classe classe) {
		classeRipository.save(classe);
	}

	@Transactional
	public void inserisciNuovo(Classe classe) {
		classeRipository.save(classe);

	}

	@Transactional
	public void rimuovi(Classe classe) {
		classeRipository.delete(classe);

	}

	@Transactional(readOnly = true)
	public List<Classe> findByExample(Classe example) {
		String query = "select c from classe c where c.id=c.id";

		if (!(ObjectUtils.isEmpty(example.getSezione())))
			query += " and c.sezione like '%" + example.getSezione() + "%'";
		if (example.getAnno() != null)
			query += " and c.anno = " + example.getAnno();
		return entityManager.createQuery(query, Classe.class).getResultList();

	}

}
