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
	private int codvac;
	
	@Column(nullable = false)
	private Date datvac;
	
	@Column(nullable = false)
	private char dosvac;
	
	@Column(nullable = true)
	private String fabvac;
	
	@ManyToOne
	@JoinColumn
	private int codpac;
	
	@ManyToOne
	@JoinColumn
	private String crmmed;
}
