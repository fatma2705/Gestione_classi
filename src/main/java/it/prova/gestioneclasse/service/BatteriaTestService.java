package it.prova.gestioneclasse.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneclasse.model.Classe;
import it.prova.gestioneclasse.model.Studente;

@Service
public class BatteriaTestService {

	@Autowired
	private ClasseService classeService;
	@Autowired
	private StudenteService studenteService;

	public void testListAllStudenti() {
		List<Studente> lista = studenteService.listAllStudenti();
		if (lista.isEmpty())
			throw new RuntimeException("testListAllStudenti.....failed, database vuoto.");
		System.out.println(lista + "\n testListAllStudenti.....OK");
	}

	public void testCaricaSingoloStudente() {
		Studente studente = studenteService.caricoSingoloStudente(28L);
		if (studente == null)
			throw new RuntimeException("testCaricaSingoloStudente.....failed, Studente non trovato.");
		System.out.println(studente + "\n testCaricaSingoloStudente.....OK");

	}

	public void testInserisciStudente() {
		LocalDate dataNascita = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dataNascita = LocalDate.parse("1985-03-22", formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		List<Classe> classiDB = classeService.listAllClassi();
		if (classiDB.isEmpty())
			throw new RuntimeException(
					"testInserisciStudente.....failed,non ci sono classi nel DB , impossibile inserire studente");
		studenteService.inserisciNuovo(new Studente(null, "1212", "fatma", "arafa", dataNascita, classiDB.get(0)));
		if (studenteService.findByExample(new Studente(null, "1212", null, null, null, null)).isEmpty()) {
			throw new RuntimeException("testInserisciStudente.....failed,inserimento non avvenuto");
		}
		System.out.println("\n testInserisciStudente...... OK");
	}

	public void testEliminaStudente() {
		List<Studente> studenteDB = studenteService.listAllStudenti();
		if (studenteDB.isEmpty())
			throw new RuntimeException("testEliminaStudente.....failed, il DB e' gia vuoto....");

		try {
			studenteService.rimuovi(studenteDB.get(0));
		} catch (Exception e) {
			System.out.println("testEliminaStudente.....failed,cancellazione non avvenuta");
		}

	}

	public void testAggiornaStudente() {
		List<Studente> studentiDb = studenteService.listAllStudenti();
		if (studentiDb.isEmpty())
			throw new RuntimeException("errore, il DB sembra essere vuoto...");
		studentiDb.get(0).setCognome("Berulli");
		Long idDaAggiornare = studentiDb.get(0).getId();

		studenteService.aggiorna(studentiDb.get(0));

		if (!studenteService.caricoSingoloStudente(idDaAggiornare).getCognome().equals("Berulli")) {
			System.out.println(studenteService.caricoSingoloStudente(idDaAggiornare).getCognome());
			throw new RuntimeException("testAggiornaStudente......failed, i dati non sono aggiornati.");
		}
		System.out.println("testAggiornaStudente.....OK");
	}

	public void testListAllClassi() {
		List<Classe> lista = classeService.listAllClassi();
		if (lista.isEmpty())
			throw new RuntimeException("testListAllClassi.....failed, database vuoto.");
		System.out.println(lista + "\n testListAllClassi.....OK");
	}

	public void testCaricaSingolaClasse() {
		Classe classe = classeService.caricaSingolaClasse(3L);
		if (classe == null)
			throw new RuntimeException("testCaricaSingolaClasse.....failed, classe non trovata.");
		System.out.println(classe + "\n testCaricaSingolaClasse.....OK");

	}

	public void testInserisciClasse() {
		classeService.inserisciNuovo(new Classe(null, 2, 'c'));
		if (classeService.findByExample(new Classe(null, null, 'c')).isEmpty()) {
			throw new RuntimeException("testInserisciClasse.....failed,inserimento non avvenuto");
		}
		System.out.println("\n testInserisciClasse...... OK");
	}

	public void testEliminaClasse() {
		List<Classe> classeDB = classeService.listAllClassi();
		if (classeDB.isEmpty())
			throw new RuntimeException("testEliminaClasse.....failed, il DB e' gia vuoto....");

		try {
			classeService.caricaSingolaClasseFetch(classeDB.get(0).getId()).getStudenti().stream().forEach(stud -> {
				studenteService.rimuovi(stud);
			});
			classeService.rimuovi(classeDB.get(0));
			System.out.println("\n testEliminaClasse...... OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("testEliminaClasse.....failed,cancellazione non avvenuta");
		}

	}

	public void testAggiornaClasse() {
		List<Classe> classiDb = classeService.listAllClassi();
		if (classiDb.isEmpty())
			throw new RuntimeException("errore, il DB sembra essere vuoto...");
		classiDb.get(0).setSezione('a');
		;
		Long idDaAggiornare = classiDb.get(0).getId();

		classeService.aggiorna(classiDb.get(0));

		if (!classeService.caricaSingolaClasse(idDaAggiornare).getSezione().equals('a')) {
			System.out.println(classeService.caricaSingolaClasse(idDaAggiornare).getSezione());
			throw new RuntimeException("testAggiornaClasse......failed, i dati non sono aggiornati.");
		}
		System.out.println("testAggiornaClasse.....OK");
	}

}
