package br.edu.unoesc.pandemicstats.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import br.edu.unoesc.pandemicstats.springboot.model.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Integer> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Vacina set crmmed = null where crmmed.crmmed = ?1")
	void setCrmNull(String cmrmed);
}
