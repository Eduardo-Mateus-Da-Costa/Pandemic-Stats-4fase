package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Paciente;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowPacSCH;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 10/11/2021
 * @version 1.6
 * @see ShowPacSCH
 * @see Paciente
 */
@Data
public class RespPac {
	private ShowPacSCH showpac = new ShowPacSCH();
	private String erro;
	private int codstatus;
	
	/**
	 * @param Paciente paciente
	 * @param int codstatus
	 */
	public void RespValPac(Paciente paciente, int codstatus)
	{
		if (codstatus == 500)
		{
			this.codstatus = codstatus;
			this.erro = "Erro interno ou variavel nula";
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
		else if (codstatus == 506)
		{
			this.codstatus = codstatus;
			this.erro = "Usuário não cadastrado";
		}
		else if (codstatus == 507)
		{
			this.codstatus = codstatus;
			this.erro = "Usuário não vinculado a empresa";
		}
		else
		{
			this.codstatus = 200;
			showpac.Convert(paciente);
		}
	}
}
