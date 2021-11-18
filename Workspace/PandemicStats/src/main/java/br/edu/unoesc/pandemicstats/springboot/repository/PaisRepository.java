package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Pais;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.0
 * @see JpaRepository
 * @see Pais
 */
@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
