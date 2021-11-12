package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMedSCH;


public class RespMed extends RespPadrao{
	private ShowMedSCH m = new ShowMedSCH();
	
	public void RespValMed(Medico med, int Httpstatus)
	{
		if(Httpstatus==501)
		{
			this.Httpstatus = Httpstatus;
			this.s = "CRM já em uso";
		}
		else
		{
			this.Httpstatus = Httpstatus;
			m.Convert(med);
		}
	}
}
