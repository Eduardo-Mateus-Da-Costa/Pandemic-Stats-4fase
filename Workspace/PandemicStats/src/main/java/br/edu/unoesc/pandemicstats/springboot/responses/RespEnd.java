package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEndSCH;
import lombok.Data;

@Data
public class RespEnd{
	private ShowEndSCH showend = new ShowEndSCH();
	private String erro;
	private int codstatus;
	
	public void RespValEnd(Endereco endereco, int codstatus)
	{
		if(codstatus==500)
		{
			this.codstatus = codstatus;
			this.erro = "Não há CNPJ nem CPF";
		}
		else
		{
			this.codstatus = codstatus;
			showend.Convert(endereco);
		}
	}
}
