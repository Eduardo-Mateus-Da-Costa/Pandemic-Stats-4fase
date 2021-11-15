package br.edu.unoesc.pandemicstats.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Query(value = "select e from Empresa e where e.cnpjemp = ?1")
	Empresa findByCNPJ(long cnpj);
	
	@Query(value = "select e from Empresa e where e.cpfusu.cpfusu = ?1")
	Empresa findByCpfusu(long cpfusu);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call grant_empresa(:usuario)")
	void grantDBEmpresa(@Param("usuario") String usuario);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call revoke_group(:usuario, :grupo)")
	void revokeEmpresa(@Param("usuario") String usuario, @Param("grupo") String grupo);
	
}
