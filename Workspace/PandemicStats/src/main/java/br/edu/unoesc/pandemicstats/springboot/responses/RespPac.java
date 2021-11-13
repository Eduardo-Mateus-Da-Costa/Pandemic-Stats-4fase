package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowPacSCH;
import lombok.Data;

@Data
public class RespPac {
	private ShowPacSCH showpac = new ShowPacSCH();
	private String erro;
	private int codstatus;
	
	public void RespValPac(Paciente paciente, int codstatus)
	{
		if (codstatus == 500)
		{
			this.codstatus = codstatus;
			this.erro = "Erro interno";
		}
		else if (codstatus == 501)
		{
			this.codstatus = codstatus;
			this.erro = "Grurispac inválido";
		}
		else if (codstatus == 502)
		{
			this.codstatus = codstatus;
			this.erro = "Sitpac inválido";
		}
		else if (codstatus == 503)
		{
			this.codstatus = codstatus;
			this.erro = "Peso inválido";
		}
		else
		{
			this.codstatus = 200;
			showpac.Convert(paciente);
		}
	}
}
