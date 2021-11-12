package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@org.hibernate.annotations.Table(comment = "Tabela de comorbidades", appliesTo = "comorbidade")
@Entity
@Data
public class Comorbidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codcom;
	
	@Column(columnDefinition = "VARCHAR(300)", nullable = false)
	private String com;
}