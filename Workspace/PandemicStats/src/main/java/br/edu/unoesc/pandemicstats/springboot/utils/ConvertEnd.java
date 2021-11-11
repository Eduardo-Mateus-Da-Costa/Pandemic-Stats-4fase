package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;

public class ConvertEnd {
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
