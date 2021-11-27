package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.unoesc.pandemicstats.springboot.data.model.TipoCidCov;
import br.unoesc.pandemicstats.springboot.data.model.TipoVw1;
import br.unoesc.pandemicstats.springboot.data.model.TipoVw2;
import br.unoesc.pandemicstats.springboot.data.model.TipoVw3;
import br.unoesc.pandemicstats.springboot.data.model.TipoVw4;

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
	
	
	/**
	 * @param long codcid
	 * @return List<Map<String, Object>>
	 */
	@Transactional
	@Query(nativeQuery = true, value ="select f.nomusu as "+ TipoCidCov.NOMUSU +","+" f.sexusu as "+ TipoCidCov.SEXUSU +","+" f.nomemp as "+ TipoCidCov.NOMEMP +" from cidade_covid(:codcid) f")
	List<Map<String, Object>> funcCidCov(@Param("codcid") long codcid);
	
	/**
	 * @return List<Map<String, Object>>
	 */
	@Transactional
	@Query(nativeQuery = true, value ="select vw.nomusu as "+ TipoVw1.NOMUSU+","+" vw.codpac as "+ TipoVw1.CODPAC +" from vw_select1 vw")
	List<Map<String, Object>> selectVw1();
	
	
	/**
	 * @return List<Map<String, Object>>
	 */
	@Transactional
	@Query(nativeQuery = true, value ="select vw.nomusu as "+ TipoVw2.NOMUSU +","+" vw.nomcid as "+ TipoVw2.NOMCID +" from vw_select2 vw")
	List<Map<String, Object>> selectVw2();
	
	
	
	/**
	 * @return List<Map<String, Object>>
	 */
	@Transactional
	@Query(nativeQuery = true, value ="select vw.codcid as "+ TipoVw3.CODCID +","+" vw.nomcid as "+ TipoVw3.NOMCID +","+"vw.conta as "+ TipoVw3.CONTA +" from vw_select3 vw")
	List<Map<String, Object>> selectVw3();
	
	
	
	/**
	 * @return List<Map<String, Object>>
	 */
	@Query(nativeQuery = true, value ="select vw.idade as "+ TipoVw4.IDADE +","+" vw.casos as "+ TipoVw4.CASOS + " from vw_select4 vw")
	List<Map<String, Object>> selectVw4();
}
