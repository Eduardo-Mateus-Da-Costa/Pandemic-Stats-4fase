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
public class Controle_Ligacao_Acesso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "NUMERIC(10, 0)")
	private int codcon;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(11, 0)", nullable = false, unique = true)
	private Usuario cpfusu;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "NUMERIC(14, 0)", nullable = true)
	private Empresa cnpjemp;
	
	@OneToOne
	@JoinColumn(columnDefinition = "VARCHAR(30)", nullable = true)
	private Medico crmmed;
	
	@OneToOne
	@JoinColumn(columnDefinition = "NUMERIC(10, 0)", nullable = true)
	private Paciente codpac;

}
