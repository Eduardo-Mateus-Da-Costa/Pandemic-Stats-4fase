package br.unoesc.pandemicstats.springboot.data.model;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class TipoVw4 implements Serializable{
	private static final long serialVersionUID = 1L;

	public static final String IDADE = "IDADE";
	public static final String CASOS = "CASOS";
	
	private String idade;
	private String casos;
	
	public TipoVw4(String idade, String casos) {
		this.idade = idade;
		this.casos = casos;
	}
	

    public TipoVw4(Map<String, Object> values) {
    	this.idade = values.get(IDADE) != null ? (String) values.get(IDADE): null;
    	this.casos = values.get(CASOS) != null ? (String) values.get(CASOS) : null;
    }
}
