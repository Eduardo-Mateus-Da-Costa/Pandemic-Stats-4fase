package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Medico;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowMedSCH;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 10/11/2021
 * @version 1.2
 * @see ShowMedSCH
 * @see Medico
 */
@Data
public class RespMed{
	private ShowMedSCH showmed = new ShowMedSCH();
	private String erro;
	private int codstatus;
	
	/**
	 * @param Medico med
	 * @param int codstatus
	 */
	public void RespValMed(Medico med, int codstatus)
	{
		if(codstatus==501)
		{
			this.codstatus = codstatus;
			this.erro = "CRM já em uso";
		}
		if(codstatus==506)
		{
			this.codstatus = codstatus;
			this.erro = "Usuário não cadastrado";
		}
		else
		{
			this.codstatus = codstatus;
			showmed.Convert(med);
		}
	}
}
