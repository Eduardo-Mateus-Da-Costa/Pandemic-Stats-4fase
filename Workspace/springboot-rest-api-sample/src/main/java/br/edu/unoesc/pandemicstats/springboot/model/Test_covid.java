package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_tes_covid", sequenceName = "seq_tes_covid", allocationSize = 1, initialValue = 1)
@Data
public class Test_covid implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tes_covid")
	private int codtes;
	
	private char covpactes;
	private Paciente codpac;
}
