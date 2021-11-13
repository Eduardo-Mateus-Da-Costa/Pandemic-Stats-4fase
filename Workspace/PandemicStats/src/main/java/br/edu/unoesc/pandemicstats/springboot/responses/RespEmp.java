package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEmpSCH;
import lombok.Data;

@Data
public class RespEmp{
	private ShowEmpSCH showemp = new ShowEmpSCH();
	private String erro;
	private int codstatus;
	
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
