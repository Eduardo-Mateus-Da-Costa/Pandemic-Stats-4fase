package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 2.6
 * @see JpaRepository
 * @see Usuario
 * @see java.util.List
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * @param long cpf
	 * @return Usuario
	 */
	@Query(value = "select u from Usuario u where u.cpfusu = ?1")
	Usuario findByCPF(long cpf);

	/**
	 * @param String email
	 * @return Usuario
	 */
	@Query(value = "select u from Usuario u where u.emausu = ?1")
	Usuario findByEmail(String email);
	
	/**
	 * @param long cnpj
	 * @return List<Usuario>
	 */
	@Query(value = "select u from Usuario u where cnpjemp.cnpjemp = ?1")
	List<Usuario> findByCnpjEmp(long cnpj);
	
	/**
	 * @param long cnpj
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Usuario set cnpjemp = null where cnpjemp.cnpjemp = ?1")
	void setCnpjempNull(long cnpj);
	
	/**
	 * @param long cpfusu
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "delete from Usuario u where u.cpfusu = ?1")
	void deleteByCPF(long cpfusu);
	
	/**
	 * @param String usuario
	 * @param String senha
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call create_user(:usuario, :senha)")
	void createDBUser(@Param("usuario") String usuario, @Param("senha") String senha);
	
	/**
	 * @param String usuario
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call grant_usuario(:usuario)")
	void grantDBUser(@Param("usuario") String usuario);
	
	/**
	 * @param String usuario
	 * @param Sring newemail
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call alter_email(:usuario, :email)")
	void alterUserEmail(@Param("usuario") String usuario, @Param("email") String email);
	
	/**
	 * @param String usuario
	 * @param String newpassword
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call alter_password(:usuario, :newpassword)")
	void alterUserPassword(@Param("usuario") String usuario, @Param("newpassword") String newpassword);
	
	/**
	 * @param String usuario
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value ="call drop_user(:usuario)")
	void dropUser(@Param("usuario") String usuario);
	
	
}
