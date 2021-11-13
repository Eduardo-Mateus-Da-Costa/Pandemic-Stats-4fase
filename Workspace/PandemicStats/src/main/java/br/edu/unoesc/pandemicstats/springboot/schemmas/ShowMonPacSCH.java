package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.MonitoramentoPaciente;
import br.edu.unoesc.pandemicstats.springboot.model.Paciente;
import br.edu.unoesc.pandemicstats.springboot.model.Sintoma;
import lombok.Data;

@Data
public class ShowMonPacSCH {
	private long codmon;
	private Date datmon;
	private char intsin;
	private long codpac;
	private long codsin;
	
	public void Convert(MonitoramentoPaciente mompac)
	{
		this.codmon = mompac.getCodmon();
		this.datmon = mompac.getDatmon();
		this.intsin = mompac.getIntsin();
		Paciente paciente = mompac.getCodpac();
		Sintoma sintoma = mompac.getCodsin();
		if (paciente != null)
		{
			this.codpac = paciente.getCodpac();
		}
		if (sintoma != null)
		{
			this.codsin = sintoma.getCodsin();
		}
	}
}
