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
public class Endereco_empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codendemp;
	
	@Column(columnDefinition = "NUMERIC(8, 0)", nullable = false)
	private int cepemp;
	
	@Column(columnDefinition = "VARCHAR(10)", nullable = false)
	private String numemp;
	
	@Column(columnDefinition = "VARCHAR(60)", nullable = false)
	private String ruaemp;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(14, 0)")
	private Empresa cnpjemp;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(6, 0)")
	private Cidade codcid;
}
