package br.edu.unoesc.pandemicstats.springboot.schemmas;

import java.sql.Date;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.model.Paciente;
import br.edu.unoesc.pandemicstats.springboot.model.Vacina;
import lombok.Data;

@Data
public class ShowVacSCH {
	private long codvac;
	private Date datvac;
	private int dosvac;
	private String fabvac;
	private long codpac;
	private String crmmed;
	
	public void Convert(Vacina vacina)
	{
		this.codvac = vacina.getCodvac();
		this.datvac = vacina.getDatvac();
		this.dosvac = vacina.getDosvac();
		this.fabvac = vacina.getFabvac();
		Medico medico = vacina.getCrmmed();
		Paciente paciente = vacina.getCodpac();
		if (medico != null)
		{
			this.crmmed = medico.getCrmmed();
		}
		if(paciente != null)
		{
			this.codpac = paciente.getCodpac();
		}
	}
}
