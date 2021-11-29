package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Sintoma;

/**
 * @author Eduardo Mateus Da Costa
 * @since 06/11/2021
 * @version 1.0
 * @see JpaRepository
 * @see Sintoma
 */
@Repository
public interface SintomaRepository extends JpaRepository<Sintoma, Long> {

	@Query(value="select s from Sintoma s where s.codsin = ?1")
	Sintoma findByCodsin(long codsin);
}
