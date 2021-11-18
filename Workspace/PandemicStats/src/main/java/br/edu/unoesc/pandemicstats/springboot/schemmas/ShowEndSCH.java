package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 11/12/2021
 * @version 1.0
 * @see Endereco
 */
@Data
public class ShowEndSCH {
	private long codend;
	private long cep;
	private String rua;
	private String num;
	private long codcid;
	
	/**
	 * @param Endereco endereco
	 * @see Cidade
	 */
	public void Convert(Endereco endereco)
	{
		this.codend = endereco.getCodend();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.num = endereco.getNum();
		Cidade cidade = endereco.getCodcid();
		if(cidade != null)
		{
			this.codcid	= cidade.getCodcid();
		}
	}
}
