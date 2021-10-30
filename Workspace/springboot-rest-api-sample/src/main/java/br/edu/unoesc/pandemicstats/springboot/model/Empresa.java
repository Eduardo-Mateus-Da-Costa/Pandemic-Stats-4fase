package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.edu.unoesc.pandemicstats.springboot.enumeracoes.RamosEmp;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa", allocationSize = 1, initialValue = 1)
@Data
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa")
	private int codemp;
	
	private String nomemp;
	private int cnpjemp;
	private String nomfanemp;
	private String telemp1;
	private String telemp2;
	private String emaemp;
	private RamosEmp ramo;
	private Ajuda codaju;
}
