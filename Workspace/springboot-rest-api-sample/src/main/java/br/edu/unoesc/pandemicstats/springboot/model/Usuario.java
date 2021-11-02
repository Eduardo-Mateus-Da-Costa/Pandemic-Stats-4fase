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
	@Column(columnDefinition = "NUMERIC(11, 0)")
	private int cpfusu;
	
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String nomusu;
	
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String senusu;
	
	@Column(columnDefinition = "DATE", nullable = false)
	private Date datnasusu;
	
	@Column(columnDefinition = "CHAR(1) CHECK( SEXUSU IN('M','F'))", nullable = false)
	private char sexusu;
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String telsusu;
	
	@Column(columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
	private String emausu;
}
