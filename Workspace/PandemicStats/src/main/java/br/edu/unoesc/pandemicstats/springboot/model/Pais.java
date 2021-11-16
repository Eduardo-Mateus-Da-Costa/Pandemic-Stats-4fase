package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@org.hibernate.annotations.Table(comment = "Tabela de paises", appliesTo = "pais")
@Entity
@Data
public class Pais implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(3, 0)", insertable = false)
	private long codpai;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String nompai;
}
