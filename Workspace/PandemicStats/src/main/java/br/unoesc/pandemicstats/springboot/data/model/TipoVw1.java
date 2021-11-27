package br.unoesc.pandemicstats.springboot.data.model;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 25/11/2021
 * @version 1.1
 * @see Map
 * @see Object
 */
@Data
public class TipoVw1 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String CODPAC = "CODPAC";
	public static final String NOMUSU = "NOMUSU";
	
	private String codpac;
	private String nomusu;
	
	/**
	 * @param values
	 */
    public TipoVw1(Map<String, Object> values) {
    	this.codpac = values.get(CODPAC) != null ? (String) values.get(CODPAC): null;
    	this.nomusu = values.get(NOMUSU) != null ? (String) values.get(NOMUSU) : null;
    }

    /**
     * @param codpac
     * @param nomusu
     */
	public TipoVw1(String codpac, String nomusu) {
		this.codpac = codpac;
		this.nomusu = nomusu;
	}
   
}
