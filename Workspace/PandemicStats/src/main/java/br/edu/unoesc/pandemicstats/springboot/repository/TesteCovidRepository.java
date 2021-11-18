package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.TesteCovid;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.2
 * @see JpaRepository
 * @see TesteCovid
 * @see java.util.List
 */
@Repository
public interface TesteCovidRepository extends JpaRepository<TesteCovid, Long> {
	
	/**
	 * 
	 * @param long codpac
	 * @return List<TesteCovid>
	 */
	@Query(value = "select tc from TesteCovid tc where tc.codpac.codpac = ?1")
	List<TesteCovid> findByCodpac(long codpac);

}
