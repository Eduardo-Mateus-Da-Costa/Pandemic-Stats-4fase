package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Vacina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codvac;
	
	private String datvac;
	private char dosvac;
	private String fabvac;
	
	@ManyToOne
	@JoinColumn
	private Paciente codpac;
	
	@ManyToOne
	@JoinColumn
	private Medico codmed;
}
