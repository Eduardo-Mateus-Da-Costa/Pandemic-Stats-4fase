package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cnpjemp;
	
	@Column(nullable = false)
	private String nomemp;
	
	@Column(nullable = true)
	private String nomfanemp;
	
	@Column(nullable = false)
	private String telemp1;
	
	@Column(nullable = true)
	private String telemp2;
	
	@Column(nullable = false, unique = true)
	private String emaemp;
	
	@Column(nullable = false)
	private String ramo;
	
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private int cpfusu;
}
