package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowUsuSCH;
import lombok.Data;

@Data
public class RespUsu{
	private ShowUsuSCH showusu = new ShowUsuSCH();
	private String erro;
	private int codstatus;
	
	public void RespValUsu(Usuario usuario, int codstatus)
	{
		if(codstatus==500)
		{
			this.codstatus = codstatus;
			this.erro = "Emails iguais.";
		}
		else if(codstatus==503)
		{
			this.codstatus = codstatus;
			this.erro = "CPFs iguais";
		}
		else if(codstatus==504)
		{
			this.codstatus = codstatus;
			this.erro = "Senha incorreta";
		}
		else if(codstatus==505)
		{
			this.codstatus = codstatus;
			this.erro = "Email não encontrado";
		}
		else
		{
			this.codstatus = 200;
			showusu.Convert(usuario);
		}
	}
}

