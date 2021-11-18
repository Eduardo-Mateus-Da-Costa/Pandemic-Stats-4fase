package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEmpSCH;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 10/11/2021
 * @version 1.3
 * @see ShowEmpSCH
 * @see Empresa
 */
@Data
public class RespEmp{
	private ShowEmpSCH showemp = new ShowEmpSCH();
	private String erro;
	private int codstatus;
	
	/**
	 * @param Empresa empresa
	 * @param int codstatus
	 */
	public void RespValEmp(Empresa empresa, int codstatus)
	{
		if(codstatus==500)
		{
			this.codstatus = codstatus;
			this.erro = "Emails iguais.";
		}
		else if(codstatus==503)
		{
			this.codstatus = codstatus;
			this.erro = "CNPJs iguais";
		}
		else
		{
			this.codstatus = 200;
			showemp.Convert(empresa);;
		}
	}

}
