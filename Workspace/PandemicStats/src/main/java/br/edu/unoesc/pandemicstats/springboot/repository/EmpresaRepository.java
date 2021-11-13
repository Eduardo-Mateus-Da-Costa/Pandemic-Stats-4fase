package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Query(value = "select e from Empresa e where e.cnpjemp = ?1")
	Empresa findByCNPJ(long cnpj);
	
	@Query(value = "select e from Empresa e where e.cpfusu.cpfusu = ?1")
	Empresa findByCpfusu(long cpfusu);
}
