package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Empresa;

public class CompleteEmp{

	public static void complete(Empresa obtido, Empresa inserido)
	{
		if(obtido.getNomemp() == null)
		{
			obtido.setNomemp(inserido.getNomemp());
		}
		if(obtido.getNomfanemp() == null)
		{
			obtido.setNomfanemp(inserido.getNomfanemp());
		}
		if(obtido.getTelemp1() == null)
		{
			obtido.setTelemp1(inserido.getTelemp1());
		}
		if(obtido.getEmaemp() == null)
		{
			obtido.setEmaemp(inserido.getEmaemp());
		}
		if(obtido.getTelemp2() == null)
		{
			obtido.setTelemp2(inserido.getTelemp2());
		}
		if(obtido.getRamemp() == null)
		{
			obtido.setRamemp(inserido.getRamemp());
		}
		if(obtido.getValemp() == null)
		{
			obtido.setValemp(inserido.getValemp());
		}
		if(obtido.getCpfusu() == null)
		{
			obtido.setCpfusu(inserido.getCpfusu());
		}
	}
}