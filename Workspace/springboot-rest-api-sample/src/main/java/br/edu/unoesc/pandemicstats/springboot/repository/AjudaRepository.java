package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.unoesc.pandemicstats.springboot.model.Ajuda;

@Repository
public interface AjudaRepository extends JpaRepository<Ajuda, Integer> {

}
