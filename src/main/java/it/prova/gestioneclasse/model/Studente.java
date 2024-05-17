package it.prova.gestioneclasse.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studente")
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "matricola")
	private String matricola;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "data_nascita")
	private LocalDate dataNascita;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classe_id", nullable = false)
	private Classe classe;

	public Studente() {

	}

	public Studente(Long id, String matricola, String nome, String cognome, LocalDate dataNascita, Classe classe) {
		this.id = id;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.classe = classe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Studente [id=" + id + ", matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome
				+ ", dataNascita=" + dataNascita;
	}

}