package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query(value = "select c from Cidade c where c.codcid = ?1")
	Cidade findByCodcid(long codcid);
	
	@Query(value = "select c from Cidade c where c.codest.codest = ?1")
	List<Cidade> findByCodest(long codest);
}
