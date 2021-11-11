package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import lombok.Data;

@Data
public class ShowEndSCH {
	private int codend;
	private int cep;
	private String rua;
	private String num;
	private int codcid;
	
	public void Convert(Endereco e)
	{
		this.codend = e.getCodend();
		this.cep = e.getCep();
		this.rua = e.getRua();
		this.num = e.getNum();
		Cidade c = e.getCodcid();
		if(c != null)
		{
			this.codcid	= c.getCodcid();
		}
	}
}
