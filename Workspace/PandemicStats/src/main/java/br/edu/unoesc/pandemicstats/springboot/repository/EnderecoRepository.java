package br.edu.unoesc.pandemicstats.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.3
 * @see JpaRepository
 * @see Endereco
 */

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	/**
	 * @param long cpf
	 * @return Endereco
	 */
	@Query(value = "select e from Endereco e where e.cpfusu.cpfusu = ?1")
	Endereco findByCPF(long cpf);
	
	/**
	 * @param long cnpj
	 * @return Endereco
	 */
	@Query(value = "select e from Endereco e where e.cnpjemp.cnpjemp = ?1")
	Endereco findByCNPJ(long cnpj);
	
	/**
	 * @param long codend
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Endereco set cpfusu = null where codend = ?1")
	void setCpfusuNull(long codend);

}
