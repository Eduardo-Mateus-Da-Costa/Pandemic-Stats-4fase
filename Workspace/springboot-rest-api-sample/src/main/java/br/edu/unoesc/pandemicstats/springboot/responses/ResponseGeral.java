package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowUsuSCH;
import lombok.Data;

@Data
public class ResponseGeral {
	private int Httpstatus;
	private ShowUsuSCH u = new ShowUsuSCH();
	private String s;
	
	public void RespValUsu(Usuario user, int Httpstatus)
	{
		if(Httpstatus==500)
		{
			this.Httpstatus = Httpstatus;
			this.s = "Emails iguais.";
		}
		else if(Httpstatus==503)
		{
			this.Httpstatus = Httpstatus;
			this.s = "CPFs iguais";
		}
		else
		{
			this.Httpstatus = 200;
			u.Convert(user);
		}
	}
}
