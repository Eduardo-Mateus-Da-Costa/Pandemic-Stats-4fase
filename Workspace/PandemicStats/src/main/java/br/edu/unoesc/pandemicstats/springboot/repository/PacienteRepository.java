package br.edu.unoesc.pandemicstats.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.3
 * @see JpaRepository
 * @see Paciente
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	/**
	 * @param long cpfusu
	 * @return Paciente
	 */
	@Query(value = "select p from Paciente p where p.cpfusu.cpfusu = ?1")
	Paciente findByCpfusu(long cpfusu);
	
	/**
	 * @param String usuario
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call grant_paciente(:usuario)")
	void grantDBPaciente(@Param("usuario") String usuario);
	
	@Query(value = "select p from Paciente p where p.codpac = ?1")
	Paciente findByCodpac(long codpac);
}
