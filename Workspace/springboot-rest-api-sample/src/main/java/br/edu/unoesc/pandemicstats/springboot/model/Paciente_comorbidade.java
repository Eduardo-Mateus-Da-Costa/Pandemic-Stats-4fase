package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Paciente_comorbidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int paccomcod;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Paciente codpac;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Comorbidade codcom;
}
