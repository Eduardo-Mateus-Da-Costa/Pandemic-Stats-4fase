package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Monitoramento_paciente;

@Repository
public interface Monitoramento_pacienteRepository extends JpaRepository<Monitoramento_paciente, Integer> {

}
