package br.edu.unoesc.pandemicstats.springboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	@Query(value = "select e from Endereco e where e.cpfusu = ?1")
	Endereco findByCPF(long cpf);
	
	@Query(value = "select e from Endereco e where e.cnpjemp = ?1")
	Endereco findByCNPJ(long cnpj);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Endereco set cpfusu = null where codend = ?1")
	void setCpfusuNull(long codend);

}
