package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.PacienteComorbidade;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.2
 * @see JpaRepository
 * @see PacienteComorbidade
 */
@Repository
public interface PacienteComorbidadeRepository extends JpaRepository<PacienteComorbidade, Long> {

	/**
	 * @param long codpac
	 * @param long codcom
	 * @return PacienteComorbidade
	 */
	@Query(value="select pc from PacienteComorbidade pc where ((pc.codpac.codpac = ?1) AND (pc.codcom.codcom = ?2))")
	PacienteComorbidade findByCodpacANDCodcom(long codpac, long codcom);
}
