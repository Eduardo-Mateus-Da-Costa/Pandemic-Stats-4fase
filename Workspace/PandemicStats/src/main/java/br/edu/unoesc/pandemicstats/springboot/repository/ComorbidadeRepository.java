package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Comorbidade;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.2
 * @see JpaRepository
 * @see Comorbidade
 * @see java.util.List
 */

@Repository
public interface ComorbidadeRepository extends JpaRepository<Comorbidade, Long> {

	/**
	 * @param long codcom
	 * @return Comorbidade
	 */
	@Query(value ="select c from Comorbidade c where c.codcom = ?1")
	Comorbidade findByCodcom(long codcom);
	
	/**
	 * @return List<Comorbidade>
	 */
	@Query(value ="select c from Comorbidade c")
	List<Comorbidade> findAllComs();
}
