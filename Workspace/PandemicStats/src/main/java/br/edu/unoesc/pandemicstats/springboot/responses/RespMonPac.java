package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.MonitoramentoPaciente;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMonPacSCH;
import lombok.Data;

@Data
public class RespMonPac {
	private ShowMonPacSCH showmompac = new ShowMonPacSCH();
	private String erro;
	private int codstatus;
	
	public void RespValMomPac(MonitoramentoPaciente mompac, int codstatus)
	{
		if (codstatus == 500)
		{
			this.codstatus = codstatus;
			this.erro = "Erro ao inserir";
		}
		else if (codstatus == 501)
		{
			this.codstatus = codstatus;
			this.erro = "Intensidade de sintoma invalido";
		}
		else
		{
			this.codstatus = 200;
			showmompac.Convert(mompac);
		}
	}
			
}
