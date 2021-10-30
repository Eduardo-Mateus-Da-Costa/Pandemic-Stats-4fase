package br.edu.unoesc.pandemicstats.springboot.model;

import br.edu.unoesc.pandemicstats.springboot.enumeracoes.FuncaoPac;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_tip_funcionario", sequenceName = "seq_tip_funcionario", allocationSize = 1, initialValue = 1)
@Data
public class Tipo_funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tip_funcionario")
	private int codfun;
	
	private FuncaoPac tipfun;
	private String desfun;
}
