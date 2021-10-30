package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1, initialValue = 1)
@Data
public class Paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	private int codpac;
	
	private String nompac;
	private int cpfpac;
	private String datnaspac;
	private double pespac;
	private String telpac1;
	private String telpac2;
	private char grurispac;
	private char sexpac;
	private String sitpac;
	private Empresa codemp;
	private Tipo_funcionario codfun;
}
