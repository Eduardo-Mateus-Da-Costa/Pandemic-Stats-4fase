package br.edu.unoesc.pandemicstats.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pandemicstats.springboot.model.Test_covid;

@Repository
public interface Test_covidRepository extends JpaRepository<Test_covid, Long> {

}
