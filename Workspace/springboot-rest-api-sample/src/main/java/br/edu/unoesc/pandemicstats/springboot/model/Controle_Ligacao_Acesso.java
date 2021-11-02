package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

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
public class Controle_Ligacao_Acesso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codcon;
	
	@OneToOne
	@JoinColumn(nullable = false, unique = true)
	private int cpfusu;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private int cnpjemp;
	
	@OneToOne
	@JoinColumn(nullable = true)
	private String crmmed;
	
	@OneToOne
	@JoinColumn(nullable = true)
	private int codpac;

}
