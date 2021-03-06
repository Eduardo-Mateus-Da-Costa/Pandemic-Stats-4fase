package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.2
 * @see lombok.Data
 */

@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de estados", appliesTo = "estado")
@Entity
@Data
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estado")
	@Column(columnDefinition = "NUMERIC(5, 0)", insertable = false)
	private long codest;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String nomest;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(3, 0)")
	private Pais codpai;
}
