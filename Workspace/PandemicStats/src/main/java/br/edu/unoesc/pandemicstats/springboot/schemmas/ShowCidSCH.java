package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 11/11/2021
 * @version 1.0
 * @see Cidade
 */
@Data
public class ShowCidSCH {
	private String nomcid;
	private long codcid;
	
	/**
	 * @param Cidade cidade
	 */
	public void Convert(Cidade cidade)
	{
		this.nomcid = cidade.getNomcid();
		this.codcid = cidade.getCodcid();
	}
}
