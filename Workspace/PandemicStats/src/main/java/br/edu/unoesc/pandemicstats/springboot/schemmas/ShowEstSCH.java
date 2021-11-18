package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Estado;
import br.edu.unoesc.pandemicstats.springboot.model.Pais;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 11/11/2021
 * @version 1.0
 * @see Estado
 */
@Data
public class ShowEstSCH {
	private String nomest;
	private long codpai;
	
	/**
	 * @param Estado estado
	 */
	public void Convert(Estado estado)
	{
		this.nomest = estado.getNomest();
		Pais pais = estado.getCodpai();
		this.codpai = pais.getCodpai();
	}
}
