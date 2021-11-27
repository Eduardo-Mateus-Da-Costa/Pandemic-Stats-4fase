package br.unoesc.pandemicstats.springboot.data.model;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class TipoVw3 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String CODCID = "CODCID";
	public static final String NOMCID = "NOMCID";
	public static final String CONTA = "CONTA";
	
	private String codcid;
	private String nomcid;
	private String conta;
	
	
	
	 public TipoVw3(Map<String, Object> values) {
	    	this.codcid = values.get(CODCID) != null ? (String) values.get(CODCID): null;
	    	this.nomcid = values.get(NOMCID) != null ? (String) values.get(NOMCID) : null;
	    	this.conta = values.get(CONTA) != null ? (String) values.get(CONTA) : null;
	    }



	public TipoVw3(String codcid, String nomcid, String conta) {
		this.codcid = codcid;
		this.nomcid = nomcid;
		this.conta = conta;
	}
}
