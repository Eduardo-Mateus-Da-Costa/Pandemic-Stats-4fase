package br.unoesc.pandemicstats.springboot.data.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class TipoCidCov implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomusu;
	private char sexusu;
	private String nomemp;
}
