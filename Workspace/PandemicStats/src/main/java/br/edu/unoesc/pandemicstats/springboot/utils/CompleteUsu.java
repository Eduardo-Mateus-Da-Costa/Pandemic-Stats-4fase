package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;

/**
 * @author Eduardo Mateus Da Costa
 * @since 12/11/2021
 * @version 1.1
 * @see Usuario
 */
public class CompleteUsu {

	/**
	 * @param Usuario obtido
	 * @param Usuario inserido
	 */
	public static void complete(Usuario obtido, Usuario inserido)
	{
		if(obtido.getCnpjemp() != null)
		{
			inserido.setCnpjemp(obtido.getCnpjemp());
		}
		if(obtido.getNomusu() != null)
		{
			inserido.setNomusu(obtido.getNomusu());
		}
		if(obtido.getSenusu() != null)
		{
			inserido.setSenusu(obtido.getSenusu());
		}
		if(obtido.getDatnasusu() != null)
		{
			inserido.setDatnasusu(obtido.getDatnasusu());
		}
		if(obtido.getSexusu() != '\u0000')
		{
			inserido.setSexusu(obtido.getSexusu());
		}
		if(obtido.getTelusu() != null)
		{
			inserido.setTelusu(obtido.getTelusu());
		}
		if(obtido.getEmausu() != null)
		{
			inserido.setEmausu(obtido.getEmausu());
		}
		if(obtido.getValusu() != null)
		{
			inserido.setValusu(obtido.getValusu());
		}
		if(obtido.getCep() != 0)
		{
			inserido.setCep(obtido.getCep());
		}
		if(obtido.getCodcid() != null)
		{
			inserido.setCodcid(obtido.getCodcid());
		}
		if(obtido.getNum() != null)
		{
			inserido.setNum(obtido.getNum());
		}
		if(obtido.getRua() != null)
		{
			inserido.setRua(obtido.getRua());
		}
	}
}
