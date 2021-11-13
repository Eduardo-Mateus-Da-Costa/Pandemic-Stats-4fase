package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	@Query(value ="select e from Estado e where codest = ?1")
	Estado findByCodest(long codest);
	
	@Query(value ="select e from Estado e where codpai.codpai = ?1")
	List<Estado> findByCodpai(long codpai);
}
