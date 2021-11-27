package br.unoesc.pandemicstats.springboot.data.model;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 25/11/2021
 * @version 1.1
 * @see Object
 * @see Map
 */
@Data
public class TipoVw2 implements Serializable{
	private static final long serialVersionUID = 1L;

	public static final String NOMUSU = "NOMUSU";
	public static final String NOMCID = "NOMCID";
	
	private String nomusu;
	private String nomcid;
	
	/**
	 * @param values
	 */
    public TipoVw2(Map<String, Object> values) {
    	this.nomusu = values.get(NOMUSU) != null ? (String) values.get(NOMUSU): null;
    	this.nomcid = values.get(NOMCID) != null ? (String) values.get(NOMCID) : null;
    }

    /**
     * @param nomusu
     * @param nomcid
     */
	public TipoVw2(String nomusu, String nomcid) {
		this.nomusu = nomusu;
		this.nomcid = nomcid;
	}
}
