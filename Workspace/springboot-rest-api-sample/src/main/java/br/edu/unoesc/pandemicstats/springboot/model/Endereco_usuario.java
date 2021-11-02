package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class Endereco_usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codendusu;
	
	@Column(columnDefinition = "NUMERIC(8, 0)", nullable = false)
	private int cepusu;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String ruausu;
	
	@Column(columnDefinition = "VARCHAR(10)", nullable = false)
	private String numusu;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(11, 0)")
	private Usuario cpfusu;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(6, 0)")
	private Cidade codcid;
}
