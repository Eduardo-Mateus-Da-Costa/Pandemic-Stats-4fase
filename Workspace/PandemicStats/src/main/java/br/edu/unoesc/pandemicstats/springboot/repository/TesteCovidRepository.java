package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.TesteCovid;

@Repository
public interface TesteCovidRepository extends JpaRepository<TesteCovid, Long> {
	
	@Query(value = "select tc from TesteCovid tc where tc.codpac.codpac = ?1")
	List<TesteCovid> findByCodpac(long codpac);

}
