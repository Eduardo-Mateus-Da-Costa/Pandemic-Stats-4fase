package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * 
 * @author Eduardo Mateus Da Costa
 * @since 30/10/2021
 * @version 1.4
 *  
 */



@org.hibernate.annotations.Table(comment = "Tabela de cidades", appliesTo = "cidade")
@Entity
@Data
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)", insertable = false)
	private long codcid;
	
	
	@Column(columnDefinition = "VARCHAR(60)")
	private String nomcid;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(5, 0)")
	private Estado codest;
}