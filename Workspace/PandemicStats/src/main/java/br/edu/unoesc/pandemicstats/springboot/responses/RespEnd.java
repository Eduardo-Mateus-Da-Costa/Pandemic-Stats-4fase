package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEndSCH;

public class RespEnd extends RespPadrao{
	private ShowEndSCH e = new ShowEndSCH();
	
	public void RespValEnd(Endereco end, int Httpstatus)
	{
		if(Httpstatus==500)
		{
			this.Httpstatus = Httpstatus;
			this.s = "Não há CNPJ nem CPF";
		}
		else
		{
			this.Httpstatus = Httpstatus;
			e.Convert(end);
		}
	}
}
