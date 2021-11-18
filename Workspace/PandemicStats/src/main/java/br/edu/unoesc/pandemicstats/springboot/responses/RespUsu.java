package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Usuario;
import br.edu.unoesc.pandemicstats.springboot.schemmas.PermisSCH;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowUsuSCH;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 08/11/2021
 * @version 1.8
 * @see ShowUsuSCH
 * @see PermisSCH
 * @see Usuario
 */
@Data
public class RespUsu{
	private ShowUsuSCH showusu = new ShowUsuSCH();
	private PermisSCH permissoes;
	private String erro;
	private int codstatus;
	
	/**
	 * @param Usuario usuario
	 * @param int codstatus
	 * @param PermisSCH permissoes
	 */
	public void RespValUsu(Usuario usuario, int codstatus, PermisSCH permissoes)
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
			this.permissoes = permissoes;
		}
	}
}

