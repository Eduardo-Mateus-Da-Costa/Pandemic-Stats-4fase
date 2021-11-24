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
 * @version 1.4
 * @see lombok.Data
 */


@SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade", allocationSize = 1, initialValue = 1)
@org.hibernate.annotations.Table(comment = "Tabela de cidades", appliesTo = "cidade")
@Entity
@Data
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cidade")
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable = false)
	private long codcid;
	
	
	@Column(columnDefinition = "VARCHAR(60)")
	private String nomcid;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(5, 0)")
	private Estado codest;
}