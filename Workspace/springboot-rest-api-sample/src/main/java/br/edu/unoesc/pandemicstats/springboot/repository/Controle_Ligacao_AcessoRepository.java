package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Controle_Ligacao_Acesso;

@Repository
public interface Controle_Ligacao_AcessoRepository extends JpaRepository<Controle_Ligacao_Acesso, Integer> {

}
