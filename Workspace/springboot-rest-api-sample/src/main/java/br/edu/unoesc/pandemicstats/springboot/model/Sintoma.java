package br.edu.unoesc.pandemicstats.springboot.model;

import br.edu.unoesc.pandemicstats.springboot.enumeracoes.ListaSint;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Sintoma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codsin;
	
	private ListaSint nomsin;
	
	private String dessin;
}
