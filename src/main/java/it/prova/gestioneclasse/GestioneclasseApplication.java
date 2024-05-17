package it.prova.gestioneclasse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestioneclasse.service.BatteriaTestService;

@SpringBootApplication
public class GestioneclasseApplication implements CommandLineRunner {

	@Autowired
	private BatteriaTestService batteriaDiTestService;

	public static void main(String[] args) {
		SpringApplication.run(GestioneclasseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("################ START   #################");
		System.out.println("################ eseguo i test  #################");

		batteriaDiTestService.testInserisciStudente();
		batteriaDiTestService.testListAllStudenti();
		batteriaDiTestService.testCaricaSingoloStudente();
		batteriaDiTestService.testEliminaStudente();
		batteriaDiTestService.testAggiornaStudente();
		batteriaDiTestService.testAggiornaClasse();
		batteriaDiTestService.testCaricaSingolaClasse();
		batteriaDiTestService.testEliminaClasse();
		batteriaDiTestService.testInserisciClasse();
		batteriaDiTestService.testListAllClassi();

		System.out.println("################ FINE   #################");
	}

}