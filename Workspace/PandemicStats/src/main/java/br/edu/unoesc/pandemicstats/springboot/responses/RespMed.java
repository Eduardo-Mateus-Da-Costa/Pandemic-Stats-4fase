package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMedSCH;
import lombok.Data;

@Data
public class RespMed{
	private ShowMedSCH showmed = new ShowMedSCH();
	private String erro;
	private int codstatus;
	
	public void RespValMed(Medico med, int codstatus)
	{
		if(codstatus==501)
		{
			this.codstatus = codstatus;
			this.erro = "CRM já em uso";
		}
		else
		{
			this.codstatus = codstatus;
			showmed.Convert(med);
		}
	}
}
