package br.edu.unoesc.pandemicstats.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	
}
