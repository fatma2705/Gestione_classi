package it.prova.gestioneclasse.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestioneclasse.model.Classe;

public interface ClasseRepository extends CrudRepository<Classe, Long>, QueryByExampleExecutor<Classe> {

	@Query("from Classe c left join c.studenti where c.id = ?1")
	@EntityGraph(attributePaths = { "studenti" })
	public Classe findByIdEager(Long id);
}