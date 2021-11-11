package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	@Query(value = "select e from Endereco e where e.cpfusu = ?1")
	Endereco findEndByCPF(int cpf);
	
	@Query(value = "select e from Endereco e where e.cnpjemp = ?1")
	Endereco findEndByCNPJ(int cnpj);
}
