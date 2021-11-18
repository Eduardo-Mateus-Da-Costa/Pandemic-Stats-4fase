package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 12/11/2021
 * @version 1.0
 * @see Paciente
 */
@Data
public class ShowPacSCH {
	private long codpac;
	private long cpfusu;
	private double pespac;
	private char grurispac;
	private String sitpac;
	
	/**
	 * @param Paciente paciente
	 * @see Usuario
	 */
	public void Convert(Paciente paciente)
	{
		this.codpac = paciente.getCodpac();
		this.grurispac = paciente.getGrurispac();
		this.pespac = paciente.getPespac();
		this.sitpac = paciente.getSitpac();
		Usuario usuario = paciente.getCpfusu();
		if (usuario != null)
		{
			this.cpfusu = usuario.getCpfusu();
		}
	}
}
