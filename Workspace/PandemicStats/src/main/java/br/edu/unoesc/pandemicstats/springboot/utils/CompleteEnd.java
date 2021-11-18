package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;

/**
 * @author Eduardo Mateus Da Costa
 * @since 12/11/2021
 * @version 1.2
 * @see Endereco
 */
public class CompleteEnd {
	
	/**
	 * @param Endereco obtido
	 * @param Endereco inserido
	 */
	public static void complete(Endereco obtido, Endereco inserido)
	{
		if(obtido.getCodend() == 0)
		{
			obtido.setCodend(inserido.getCodend());
		}
		if(obtido.getCep() == 0)
		{
			obtido.setCep(inserido.getCep());
		}
		if(obtido.getRua() == null)
		{
			obtido.setRua((inserido.getRua()));
		}
		if(obtido.getNum() == null)
		{
			obtido.setNum((inserido.getNum()));
		}
		if(obtido.getCpfusu() == null)
		{
			obtido.setCpfusu(inserido.getCpfusu());
		}
		if(obtido.getCnpjemp() == null)
		{
			obtido.setCnpjemp(inserido.getCnpjemp());
		}
		if(obtido.getCodcid() == null)
		{
			obtido.setCodcid(inserido.getCodcid());
		}
		if(obtido.getCpfusu() == null)
		{
			obtido.setCpfusu(inserido.getCpfusu());
		}
	}
}
