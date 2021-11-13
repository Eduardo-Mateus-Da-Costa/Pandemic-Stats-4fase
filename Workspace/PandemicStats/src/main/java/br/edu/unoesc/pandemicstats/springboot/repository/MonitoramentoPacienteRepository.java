package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.MonitoramentoPaciente;

@Repository
public interface MonitoramentoPacienteRepository extends JpaRepository<MonitoramentoPaciente, Long> {
	
	@Query(value = "select mp from MonitoramentoPaciente mp where mp.codpac.codpac = ?1")
	List<MonitoramentoPaciente> findByCodpac(long codpac);
}
