package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Vacina;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowVacSCH;
import lombok.Data;

@Data
public class RespVac {
	private ShowVacSCH showvac = new ShowVacSCH();
	private String erro;
	private int codstatus;
	
	public void RespValVac(Vacina vacina, int codstatus)
	{
		if(codstatus == 1)
		{
			this.codstatus = 201;
			this.erro = "Medico informado nao cadastrado";
			showvac.Convert(vacina);
		}
		else if(codstatus == 501)
		{
			this.codstatus = codstatus;
			this.erro = "Dosvac ou Datvac invalida";
		}
		else if(codstatus == 502)
		{
			this.codstatus = codstatus;
			this.erro = "Dose ja tomada";
		}
		else
		{
			this.codstatus = 200;
			showvac.Convert(vacina);
		}
	}
}
