package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codpac;
	
	@Column(columnDefinition = "NUMERIC(5, 2)", nullable = false)
	private double pespac;
	
	@Column(columnDefinition = "CHAR(1) CHECK(GRURISPAC IN ('S', 'N'))", nullable = false)
	private char grurispac;
	
	@Column(columnDefinition = "VARCHAR(20) CHECK(SITPAC IN ('INTERNADO', 'ISOLAMENTO', 'CURADO'))", nullable = false)
	private String sitpac;
}
