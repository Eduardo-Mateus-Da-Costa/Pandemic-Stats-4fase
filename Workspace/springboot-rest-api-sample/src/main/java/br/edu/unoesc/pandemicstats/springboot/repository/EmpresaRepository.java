package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	@Query(value = "select e from Empresa e where e.cnpjemp = ?1")
	Empresa findByCNPJ(int cnpj);
}
