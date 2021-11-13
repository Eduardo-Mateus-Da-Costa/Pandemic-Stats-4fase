package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente_comorbidade;

@Repository
public interface Paciente_comorbidadeRepository extends JpaRepository<Paciente_comorbidade, Long> {

}
