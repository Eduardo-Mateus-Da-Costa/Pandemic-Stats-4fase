package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Estado;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version
 * @see JpaRepository
 * @see Estado
 * @see java.util.List 
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	/**
	 * @param long codest
	 * @return Estado
	 */
	@Query(value ="select e from Estado e where codest = ?1")
	Estado findByCodest(long codest);
	
	/**
	 * @param long codpai
	 * @return List<Estado>
	 */
	@Query(value ="select e from Estado e where codpai.codpai = ?1")
	List<Estado> findByCodpai(long codpai);
}
