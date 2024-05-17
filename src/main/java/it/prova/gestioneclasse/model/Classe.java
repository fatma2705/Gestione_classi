package it.prova.gestioneclasse.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "anno")
	private Integer anno;
	@Column(name = "sezione")
	private Character sezione;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	private Set<Studente> studenti = new HashSet<>();

	public Classe() {

	}

	public Classe(Long id, Integer anno, Character sezione) {
		this.id = id;
		this.anno = anno;
		this.sezione = sezione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Character getSezione() {
		return sezione;
	}

	public void setSezione(Character sezione) {
		this.sezione = sezione;
	}

	public Set<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Studente> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", anno=" + anno + ", sezione=" + sezione;
	}

}