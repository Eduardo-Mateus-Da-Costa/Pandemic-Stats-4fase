package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String> {

	@Query(value = "select m from Medico m where m.crmmed = ?1")
	Medico findByCRM(String crm);
	
	@Query(value = "select m from Medico m where m.cpfusu.cpfusu = ?1")
	Medico findByCPF(long cpfusu);
}
