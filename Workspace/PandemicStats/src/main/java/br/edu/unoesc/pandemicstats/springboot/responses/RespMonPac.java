package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.MonitoramentoPaciente;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMonPacSCH;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 10/11/2021
 * @version 1.3
 * @see ShowMomPacSCH
 * @see MonitoramentoPaciente
 */
@Data
public class RespMonPac {
	private ShowMonPacSCH showmompac = new ShowMonPacSCH();
	private String erro;
	private int codstatus;
	
	/**
	 * @param MonitoramentoPaciente mompac
	 * @param int codstatus
	 */
	public void RespValMomPac(MonitoramentoPaciente mompac, int codstatus)
	{
		if (codstatus == 500)
		{
			this.codstatus = codstatus;
			this.erro = "Erro interno ou variavel nula";
		}
		else if (codstatus == 501)
		{
			this.codstatus = codstatus;
			this.erro = "Intensidade de sintoma invalido";
		}
		else if (codstatus == 506)
		{
			this.codstatus = codstatus;
			this.erro = "Pacinete não encontrado";
		}
		else if (codstatus == 507)
		{
			this.codstatus = codstatus;
			this.erro = "Sintoma não encontrado";
		}
		else
		{
			this.codstatus = 200;
			showmompac.Convert(mompac);
		}
	}
			
}
