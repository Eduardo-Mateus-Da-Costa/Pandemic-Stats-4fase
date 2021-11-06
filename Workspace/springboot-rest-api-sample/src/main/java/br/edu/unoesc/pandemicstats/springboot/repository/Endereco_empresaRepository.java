package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco_empresa;

@Repository
public interface Endereco_empresaRepository extends JpaRepository<Endereco_empresa, Integer> {

}
