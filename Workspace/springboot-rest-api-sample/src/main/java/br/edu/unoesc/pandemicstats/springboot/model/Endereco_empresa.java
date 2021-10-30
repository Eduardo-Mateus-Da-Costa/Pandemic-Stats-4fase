package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_end_empresa", sequenceName = "seq_end_empresa", allocationSize = 1, initialValue = 1)
@Data
public class Endereco_empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_end_empresa")
	private int codendemp;
	
	private int cepemp;
	private String numemp;
	private String ruaemp;
	private Empresa codemp;
	private Cidade codcid;
}
