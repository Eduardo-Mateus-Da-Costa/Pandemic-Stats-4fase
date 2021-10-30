package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_vacina", sequenceName = "seq_vacina", allocationSize = 1, initialValue = 1)
@Data
public class Vacina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vacina")
	private int codvac;
	
	private String datvac;
	private char dosvac;
	private String fabvac;
	private Paciente codpac;
	private Medico codmed;
}
