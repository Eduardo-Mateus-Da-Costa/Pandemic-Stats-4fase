package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;

public class ConvertUsu {

	public static void complete(Usuario obtido, Usuario inserido)
	{
		if(obtido.getCnpjemp() == null)
		{
			obtido.setCnpjemp(inserido.getCnpjemp());
		}
		if(obtido.getNomusu() == null)
		{
			obtido.setNomusu(inserido.getNomusu());
		}
		if(obtido.getSenusu() == null)
		{
			obtido.setSenusu(inserido.getSenusu());
		}
		if(obtido.getDatnasusu() == null)
		{
			obtido.setDatnasusu(inserido.getDatnasusu());
		}
		if(obtido.getSexusu() == ' ')
		{
			obtido.setSexusu(inserido.getSexusu());
		}
		if(obtido.getTelusu() == null)
		{
			obtido.setTelusu(inserido.getTelusu());
		}
		if(obtido.getEmausu() == null)
		{
			obtido.setEmausu(inserido.getEmausu());
		}
		if(obtido.getValusu() == null)
		{
			obtido.setValusu(inserido.getValusu());
		}
	}
}
