package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Cidade;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.3
 * @see JpaRepository
 * @see Cidade
 * @see java.util.List 
 */

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	/**
	 * 
	 * @param long codcid 
	 * @return Cidade
	 * 
	 */
	@Query(value = "select c from Cidade c where c.codcid = ?1")
	Cidade findByCodcid(long codcid);
	
	/**
	 * 
	 * @param long codest
	 * @return List<Cidade>
	 * 
	 */
	
	@Query(value = "select c from Cidade c where c.codest.codest = ?1")
	List<Cidade> findByCodest(long codest);
}
