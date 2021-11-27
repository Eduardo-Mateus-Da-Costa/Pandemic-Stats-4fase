package br.unoesc.pandemicstats.springboot.data.model;


import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class TipoEmpCov implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String SEXUSU = "SEXUSU";
	public static final String NOMUSU = "NOMUSU";
	public static final String NOMCID = "NOMCID";
	
	private String nomusu;
	private String sexusu;
	private String nomcid;
	
	public TipoEmpCov(Map<String, Object> values) {
    	this.nomcid = values.get(NOMCID) != null ? (String) values.get(NOMCID): null;
    	this.nomusu = values.get(NOMUSU) != null ? (String) values.get(NOMUSU) : null;
    	this.sexusu = values.get(SEXUSU) != null ? (String) values.get(SEXUSU) : null;
    }

	public TipoEmpCov(String nomusu, String sexusu, String nomcid) {
		this.nomusu = nomusu;
		this.sexusu = sexusu;
		this.nomcid = nomcid;
	}
	
	
}
