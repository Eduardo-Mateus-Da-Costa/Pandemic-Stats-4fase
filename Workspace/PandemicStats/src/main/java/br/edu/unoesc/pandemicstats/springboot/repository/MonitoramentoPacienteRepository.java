package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.MonitoramentoPaciente;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.2
 * @see JpaRepository
 * @see MonitoramentoPaciente
 * @see java.util.List 
 */
@Repository
public interface MonitoramentoPacienteRepository extends JpaRepository<MonitoramentoPaciente, Long> {
	
	/**
	 * @param long codpac
	 * @return List<MonitoramentoPaciente>
	 */
	@Query(value = "select mp from MonitoramentoPaciente mp where mp.codpac.codpac = ?1")
	List<MonitoramentoPaciente> findByCodpac(long codpac);
}
