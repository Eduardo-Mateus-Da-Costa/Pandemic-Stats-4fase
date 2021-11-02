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
	private int codendemp;
	
	@Column(nullable = false)
	private int cepemp;
	
	@Column(nullable = false)
	private String numemp;
	
	@Column(nullable = false)
	private String ruaemp;
	
	@OneToOne
	@JoinColumn
	private int cnpjemp;
	
	@ManyToOne
	@JoinColumn
	private int codcid;
}
