package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "select u from Usuario u where u.cpfusu = ?1")
	Usuario findByCPF(long cpf);

	@Query(value = "select u from Usuario u where u.emausu = ?1")
	Usuario findByEmail(String email);
	
	@Query(value = "select u from Usuario u where cnpjemp.cnpjemp = ?1")
	List<Usuario> findByCnpjEmp(long cnpj);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Usuario set cnpjemp = null where cnpjemp.cnpjemp = ?1")
	void setCnpjempNull(long cnpj);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "delete from Usuario u where u.cpfusu = ?1")
	void deleteByCPF(long cpfusu);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call create_user(:usuario, :senha)")
	void createDBUser(@Param("usuario") String usuario, @Param("senha") String senha);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call grant_usuario(:usuario)")
	void grantDBUser(@Param("usuario") String usuario);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call alter_email(:usuario, :newemail)")
	void alterUserEmail(@Param("usuario") String usuario, @Param("newemail") String newemail);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call alter_password(:usuario, :newpassword)")
	void alterUserPassword(@Param("usuario") String usuario, @Param("newpassword") String newpassword);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call drop_user(:usuario)")
	void dropUser(@Param("usuario") String usuario);
	
	
}
