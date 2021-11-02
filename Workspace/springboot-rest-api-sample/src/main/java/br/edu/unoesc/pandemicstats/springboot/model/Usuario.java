package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cpfusu;
	
	@Column(nullable = false)
	private String nomusu;
	
	@Column(nullable = false)
	private String senusu;
	
	@Column(nullable = false)
	private Date datnasusu;
	
	@Column(nullable = false)
	private char sexusu;
	
	@Column(nullable = false)
	private String telsusu;
	
	@Column(nullable = false, unique = true)
	private String emausu;
}
