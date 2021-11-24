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
 * @version 1.1
 * @see lombok.Data
 */

@SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de paises", appliesTo = "pais")
@Entity
@Data
public class Pais implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pais")
	@Column(columnDefinition = "NUMERIC(3, 0)", insertable = false)
	private long codpai;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false, unique=true)
	private String nompai;
}
