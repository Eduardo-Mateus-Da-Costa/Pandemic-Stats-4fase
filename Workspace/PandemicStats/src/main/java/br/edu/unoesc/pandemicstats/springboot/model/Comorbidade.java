package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.2
 * @see lombok.Data
 */

@SequenceGenerator(name = "seq_comorbidade", sequenceName = "seq_comorbidade", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de comorbidades", appliesTo = "comorbidade")
@Entity
@Data
public class Comorbidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comorbidade")
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable = false)
	private long codcom;
	
	@Column(columnDefinition = "VARCHAR(300)", nullable = false)
	private String com;
}
