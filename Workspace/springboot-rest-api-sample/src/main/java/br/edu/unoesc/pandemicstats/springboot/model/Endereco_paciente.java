package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
@Entity
@SequenceGenerator(name = "seq_end_paciente", sequenceName = "seq_end_paciente", allocationSize = 1, initialValue = 1)
@Data
public class Endereco_paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_end_paciente")
	private int codendpac;
	
	private int ceppac;
	private String ruapac;
	private String numpac;
	private Paciente codpac;
	private Cidade codcid;
}
