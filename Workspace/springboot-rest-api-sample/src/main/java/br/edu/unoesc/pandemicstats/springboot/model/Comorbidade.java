package br.edu.unoesc.pandemicstats.springboot.model;

import br.edu.unoesc.pandemicstats.springboot.enumeracoes.ListaComo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_comorbidade", sequenceName = "seq_comorbidade", allocationSize = 1, initialValue = 1)
@Data
public class Comorbidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comorbidade")
	private int codcom;
	
	private ListaComo com;
}
