package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Empresa;

/**
 * @author Eduardo Mateus Da Costa
 * @since 12/11/2021
 * @version 1.2
 * @see Empresa
 */
public class CompleteEmp{

	/**
	 * @param Empresa obtido
	 * @param Empresa inserido
	 */
	public static void complete(Empresa obtido, Empresa inserido)
	{
		if(obtido.getNomemp() != null)
		{
			inserido.setNomemp(obtido.getNomemp());
		}
		if(obtido.getNomfanemp() != null)
		{
			inserido.setNomfanemp(obtido.getNomfanemp());
		}
		if(obtido.getTelemp1() != null)
		{
			inserido.setTelemp1(obtido.getTelemp1());
		}
		if(obtido.getEmaemp() != null)
		{
			inserido.setEmaemp(obtido.getEmaemp());
		}
		if(obtido.getTelemp2() != null)
		{
			inserido.setTelemp2(obtido.getTelemp2());
		}
		if(obtido.getRamemp() != null)
		{
			inserido.setRamemp(obtido.getRamemp());
		}
		if(obtido.getValemp() != null)
		{
			inserido.setValemp(obtido.getValemp());
		}
		if(obtido.getCpfusu() != null)
		{
			inserido.setCpfusu(obtido.getCpfusu());
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
