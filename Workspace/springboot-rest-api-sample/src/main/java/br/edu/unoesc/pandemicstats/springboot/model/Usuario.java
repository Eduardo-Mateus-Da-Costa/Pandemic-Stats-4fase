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
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codusu;
	
	private String nomusu;
	private String logusu;
	private String senusu;
	private char tipusu;
	
	@ManyToOne
	@JoinColumn
	private Empresa codemp;
	
	@OneToOne
	@JoinColumn
	private Paciente codpac;
	
	@OneToOne
	@JoinColumn
	private Medico codmed;
}
