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
	private int codpac;
	
	@Column(nullable = false)
	private double pespac;
	
	@Column(nullable = false)
	private char grurispac;
	
	@Column(nullable = false)
	private String sitpac;
}
