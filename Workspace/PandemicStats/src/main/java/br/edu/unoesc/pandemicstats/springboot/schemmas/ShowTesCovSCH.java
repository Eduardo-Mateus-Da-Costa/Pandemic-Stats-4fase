package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;
import br.edu.unoesc.pandemicstats.springboot.model.TesteCovid;
import lombok.Data;

@Data
public class ShowTesCovSCH {
	private long codtes;
	private Date dattes;
	private char covpactes;
	private long codpac;
	
	public void Convert(TesteCovid teste)
	{
		this.codtes = teste.getCodtes();
		this.dattes = teste.getDattes();
		this.covpactes = teste.getCovpactes();
		Paciente paciente = teste.getCodpac();
		this.codpac = paciente.getCodpac();
	}
}
