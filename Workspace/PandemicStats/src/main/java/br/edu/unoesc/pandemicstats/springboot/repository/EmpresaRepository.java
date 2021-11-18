package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.schemmas.EmpresaCovidSCH;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.8
 * @see JpaRepository
 * @see Empresa
 * @see java.util.List
 * @see EmpresaCovidSCH
 */

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	/**
	 * @param long cnpj
	 * @return Empresa
	 */
	
	@Query(value = "select e from Empresa e where e.cnpjemp = ?1")
	Empresa findByCnpjemp(long cnpj);
	
	/**
	 * @param long cpfusu
	 * @return Empresa
	 */
	@Query(value = "select e from Empresa e where e.cpfusu.cpfusu = ?1")
	Empresa findByCpfusu(long cpfusu);
	
	/**
	 * @param String usuario
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call grant_empresa(:usuario)")
	void grantDBEmpresa(@Param("usuario") String usuario);
	
	/**
	 * @param String usuario
	 * @param String grupo
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call revoke_group(:usuario, :grupo)")
	void revokeEmpresa(@Param("usuario") String usuario, @Param("grupo") String grupo);
	
	/**
	 * @param long codigo
	 * @return List<EmpresaCovidSCH>
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="select empresa_covid(:codigo)")
	List<EmpresaCovidSCH> empresaCovid(@Param("codigo") long codigo);
	
}
