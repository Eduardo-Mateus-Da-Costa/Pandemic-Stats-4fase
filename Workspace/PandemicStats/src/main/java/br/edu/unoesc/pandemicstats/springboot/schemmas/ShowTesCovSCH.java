package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;
import br.edu.unoesc.pandemicstats.springboot.model.TesteCovid;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 11/11/2021
 * @version 1.0
 * @see TesteCovid
 */
@Data
public class ShowTesCovSCH {
	private long codtes;
	private Date dattes;
	private char covpactes;
	private long codpac;
	
	/**
	 * @param teste
	 * @see Paciente
	 */
	public void Convert(TesteCovid teste)
	{
		this.codtes = teste.getCodtes();
		this.dattes = teste.getDattes();
		this.covpactes = teste.getCovpactes();
		Paciente paciente = teste.getCodpac();
		this.codpac = paciente.getCodpac();
	}
}
