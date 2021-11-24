package br.edu.unoesc.pandemicstats.springboot.utils;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;

/**
 * @author Eduardo Mateus Da Costa
 * @since 12/11/2021
 * @version 1.2
 * @see Paciente
 */
public class CompletePac {
	/**
	 * @param Paciente obtido
	 * @param Paciente inserido
	 */
	public static void complete(Paciente obtido, Paciente inserido)
	{
		if(obtido.getCpfusu() != null)
		{
			inserido.setCpfusu(obtido.getCpfusu());
		}
		if(obtido.getGrurispac() != ' ')
		{
			inserido.setGrurispac(obtido.getGrurispac());
		}
		if(obtido.getPespac() != 0)
		{
			inserido.setPespac(obtido.getPespac());
		}
		if(obtido.getSitpac() != null)
		{
			inserido.setSitpac(obtido.getSitpac());
		}
	}
}
