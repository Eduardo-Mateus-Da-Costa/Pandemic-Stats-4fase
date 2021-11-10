package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@org.hibernate.annotations.Table(comment = "Tabela de sintomas", appliesTo = "sintoma")
@Entity
@Data
public class Sintoma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codsin;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String nomsin;
	
	@Column(columnDefinition = "VARCHAR(300)", nullable = true)
	private String dessin;
}
