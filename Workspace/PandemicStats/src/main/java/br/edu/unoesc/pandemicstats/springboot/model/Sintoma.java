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

@SequenceGenerator(name = "seq_sintoma", sequenceName = "seq_sintoma", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de sintomas", appliesTo = "sintoma")
@Entity
@Data
public class Sintoma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sintoma")
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable=false)
	private long codsin;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String nomsin;
}
