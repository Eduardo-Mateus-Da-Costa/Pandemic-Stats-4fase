package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco_usuario;

@Repository
public interface Endereco_usuarioRepository extends JpaRepository<Endereco_usuario, Integer> {

}
