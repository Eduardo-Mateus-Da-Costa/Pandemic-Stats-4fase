package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Monitoramento_paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codmon;
	
	@Column(nullable = false)
	private Date datmon;
	
	@Column(nullable = false)
	private char intsin;
	
	@ManyToOne
	@JoinColumn
	private int codpac;
	
	@ManyToOne
	@JoinColumn
	private int codsin;
}
