package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value = "select u from Usuario u where u.cpfusu = ?1")
	Usuario findByCPF(int cpf);

	@Query(value = "select u from Usuario u where u.emausu = ?1")
	Usuario findByEmail(String email);
}
