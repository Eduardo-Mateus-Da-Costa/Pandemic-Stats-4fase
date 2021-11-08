package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import br.edu.unoesc.pandemicstats.springboot.schemmas.UsuarioSCH;
import lombok.Data;

@Data
public class ResponseGeral {
	private int Httpstatus;
	private UsuarioSCH u;
	private String s;
	
	public void RespValUsu(Usuario user, int Httpstatus)
	{
		if(Httpstatus == 500)
		{
			this.Httpstatus = Httpstatus;
			this.s = "Cpf ou email inválidos, o sistema não permite dois cpfs ou emails iguais.";
		}
		else
		{
			this.Httpstatus = 200;
			u.Convert(user); 
		}
	}
}
