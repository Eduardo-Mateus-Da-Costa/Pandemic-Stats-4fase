package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Comorbidade;


@Repository
public interface ComorbidadeRepository extends JpaRepository<Comorbidade, Long> {

	@Query(value ="select c from Comorbidade c where c.codcom = ?1")
	Comorbidade findByCodcom(long codcom);
	
	@Query(value ="select c from Comorbidade")
	List<Comorbidade> findAllComs();
}
