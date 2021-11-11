package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEndSCH;
import lombok.Data;

@Data
public class RespEnd {
	private int Httpstatus;
	private ShowEndSCH e = new ShowEndSCH();
	private String s;
	
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
