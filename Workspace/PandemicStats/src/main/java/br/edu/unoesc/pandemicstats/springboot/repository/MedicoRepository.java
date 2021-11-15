package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.schemmas.CidadeCovidSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.EmpresaCovidSCH;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String> {

	@Query(value = "select m from Medico m where m.crmmed = ?1")
	Medico findByCRM(String crm);
	
	@Query(value = "select m from Medico m where m.cpfusu.cpfusu = ?1")
	Medico findByCPF(long cpfusu);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call grant_medico(:usuario)")
	void grantDBMedico(@Param("usuario") String usuario);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call revoke_group(:usuario, :grupo)")
	void revokeMedico(@Param("usuario") String usuario, @Param("grupo") String grupo);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="select cidade_covid(:codigo)")
	List<CidadeCovidSCH> cidadeCovid(@Param("codigo") long codigo);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="select empresa_covid(:codigo)")
	List<EmpresaCovidSCH> empresaCovid(@Param("codigo") long codigo);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="select p_dose_cidade(:codigo)")
	long PDoseCidade(@Param("codigo") long codigo);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="select s_dose_cidade(:codigo)")
	long SDoseCidade(@Param("codigo") long codigo);
}
