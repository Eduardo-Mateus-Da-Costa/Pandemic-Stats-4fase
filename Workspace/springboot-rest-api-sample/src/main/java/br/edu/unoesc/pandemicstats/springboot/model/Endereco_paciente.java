package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class Endereco_paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codendpac;
	
	private int ceppac;
	private String ruapac;
	private String numpac;
	
	@OneToOne
	@JoinColumn
	private Paciente codpac;
	
	@ManyToOne
	@JoinColumn
	private Cidade codcid;
}
