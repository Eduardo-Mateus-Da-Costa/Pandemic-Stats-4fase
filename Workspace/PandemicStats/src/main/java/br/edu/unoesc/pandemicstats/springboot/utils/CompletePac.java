package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;

public class CompletePac {
	public static void complete(Paciente obtido, Paciente inserido)
	{
		if(obtido.getCpfusu() == null)
		{
			obtido.setCpfusu(inserido.getCpfusu());
		}
		if(obtido.getGrurispac() == ' ')
		{
			obtido.setGrurispac(inserido.getGrurispac());
		}
		if(obtido.getPespac() == 0)
		{
			obtido.setPespac(inserido.getPespac());
		}
		if(obtido.getSitpac() == null)
		{
			obtido.setSitpac(inserido.getSitpac());
		}
	}
}
