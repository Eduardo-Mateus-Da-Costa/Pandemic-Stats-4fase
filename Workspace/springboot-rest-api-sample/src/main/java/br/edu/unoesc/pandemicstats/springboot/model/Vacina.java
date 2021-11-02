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
public class Vacina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(11, 0)")
	private int codvac;
	
	@Column(columnDefinition = "DATE", nullable = false)
	private Date datvac;
	
	@Column(columnDefinition = "CHAR(1) CHECK(DOSVAC IN('1', '2'))", nullable = false)
	private char dosvac;
	
	@Column(columnDefinition = "VARCHAR(30)", nullable = true)
	private String fabvac;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)")
	private Paciente codpac;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "VARCHAR(30)")
	private Medico crmmed;
}
