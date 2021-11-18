package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Solicitacao;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.0
 * @see JpaRepository
 * @see Solicitacao
 */
@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

}
