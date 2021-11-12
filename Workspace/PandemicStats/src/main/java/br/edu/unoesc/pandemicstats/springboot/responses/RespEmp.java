package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEmpSCH;

public class RespEmp extends RespPadrao{
	private ShowEmpSCH e = new ShowEmpSCH();
	
	public void RespValEmp(Empresa emp, int Httpstatus)
	{
		if(Httpstatus==500)
		{
			this.Httpstatus = Httpstatus;
			this.s = "Emails iguais.";
		}
		else if(Httpstatus==503)
		{
			this.Httpstatus = Httpstatus;
			this.s = "CNPJs iguais";
		}
		else
		{
			this.Httpstatus = 200;
			e.Convert(emp);;
		}
	}

}
