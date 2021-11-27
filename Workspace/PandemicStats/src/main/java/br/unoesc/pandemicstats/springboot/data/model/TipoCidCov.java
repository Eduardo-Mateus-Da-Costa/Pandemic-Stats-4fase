package br.unoesc.pandemicstats.springboot.data.model;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class TipoCidCov implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String SEXUSU = "SEXUSU";
	public static final String NOMUSU = "NOMUSU";
	public static final String NOMEMP = "NOMEMP";
	
	private String nomusu;
	private String sexusu;
	private String nomemp;
	
	public TipoCidCov(Map<String, Object> values) {
    	this.nomemp = values.get(NOMEMP) != null ? (String) values.get(NOMEMP): null;
    	this.nomusu = values.get(NOMUSU) != null ? (String) values.get(NOMUSU) : null;
    	this.sexusu = values.get(SEXUSU) != null ? (String) values.get(SEXUSU) : null;
    }

	public TipoCidCov(String nomusu, String sexusu, String nomemp) {
		this.nomusu = nomusu;
		this.sexusu = sexusu;
		this.nomemp = nomemp;
	}
	
	
}
