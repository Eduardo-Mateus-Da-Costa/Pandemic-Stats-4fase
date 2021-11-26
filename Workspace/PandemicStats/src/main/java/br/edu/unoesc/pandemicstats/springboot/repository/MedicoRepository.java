package br.edu.unoesc.pandemicstats.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 2.3
 * @see JpaRepository
 * @see Medico
 * @see java.util.List 
 */

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String> {

	/**
	 * @param String crm
	 * @return Medico
	 */
	@Query(value = "select m from Medico m where m.crmmed = ?1")
	Medico findByCRM(String crm);
	
	/**
	 * @param long cpfusu
	 * @return Medico
	 */
	@Query(value = "select m from Medico m where m.cpfusu.cpfusu = ?1")
	Medico findByCPF(long cpfusu);
	
	/**
	 * @param String usuario
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call grant_medico(:usuario)")
	void grantDBMedico(@Param("usuario") String usuario);
	
	/**
	 * @param String usuario
	 * @param String grupo
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call revoke_group(:usuario, :grupo)")
	void revokeMedico(@Param("usuario") String usuario, @Param("grupo") String grupo);
	
	/**
	 * @param long codigo
	 * @return long
	 */
	@Transactional
	@Query(nativeQuery = true, value ="select p_dose_cidade(:codigo)")
	long PDoseCidade(@Param("codigo") long codigo);
	
	/**
	 * @param long codigo
	 * @return long
	 */
	@Transactional
	@Query(nativeQuery = true, value ="select s_dose_cidade(:codigo)")
	long SDoseCidade(@Param("codigo") long codigo);
}
