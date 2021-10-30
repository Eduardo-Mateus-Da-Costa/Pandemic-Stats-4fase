package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.unoesc.pandemicstats.springboot.enumeracoes.RamosEmp;

import lombok.Data;

@Entity
@Data
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codemp;
	
	private String nomemp;
	private int cnpjemp;
	private String nomfanemp;
	private String telemp1;
	private String telemp2;
	private String emaemp;
	private RamosEmp ramo;
	
	@ManyToOne
	@JoinColumn
	private Ajuda codaju;
}
