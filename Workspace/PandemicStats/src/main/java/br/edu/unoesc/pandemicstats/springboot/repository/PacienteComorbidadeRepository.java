package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.PacienteComorbidade;

@Repository
public interface PacienteComorbidadeRepository extends JpaRepository<PacienteComorbidade, Long> {

	@Query(value="select pc from PacienteComorbidade pc where ((pc.codpac.codpac = ?1) AND (pc.codcom.codcom = ?2))")
	PacienteComorbidade findByCodpacANDCodcom(long codpac, long codcom);
}
