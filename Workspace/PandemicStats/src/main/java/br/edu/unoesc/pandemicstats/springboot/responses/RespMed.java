package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMedSCH;
import lombok.Data;

@Data
public class RespMed{
	private ShowMedSCH m = new ShowMedSCH();
	private String s;
	private int Httpstatus;
	
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
