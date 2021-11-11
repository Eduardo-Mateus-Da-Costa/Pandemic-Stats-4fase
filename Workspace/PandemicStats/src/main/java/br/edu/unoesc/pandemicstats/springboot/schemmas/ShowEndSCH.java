package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Empresa;
import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import lombok.Data;

@Data
public class ShowEndSCH {
	private int codend;
	private int cep;
	private String rua;
	private String num;
	private int cpfusu;
	private int cnpjemp;
	private int codcid;
	
	public void Convert(Endereco e)
	{
		this.codend = e.getCodend();
		this.cep = e.getCep();
		this.rua = e.getRua();
		this.num = e.getNum();
		Usuario u = e.getCpfusu();
		Empresa emp = e.getCnpjemp();
		Cidade c = e.getCodcid();
		if(u != null)
		{
			this.cpfusu = u.getCpfusu();
		}
		if(emp != null)
		{
			this.cnpjemp = emp.getCnpjemp();
		}
		if(c != null)
		{
			this.codcid	= c.getCodcid();
		}
	}
}
