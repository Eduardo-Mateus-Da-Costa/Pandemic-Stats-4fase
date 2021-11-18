package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import br.edu.unoesc.pandemicstats.springboot.model.Vacina;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.4
 * @see JpaRepository
 * @see Vacina
 */
@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
	
	/**
	 * @param String cmrmed
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Vacina set crmmed = null where crmmed.crmmed = ?1")
	void setCrmNull(String cmrmed);
	
	/**
	 * @param long codpac
	 * @return List<Vacina>
	 */
	@Query(value = "select v from Vacina v where v.codpac.codpac = ?1")
	List<Vacina> findByCodpac(long codpac);
}
