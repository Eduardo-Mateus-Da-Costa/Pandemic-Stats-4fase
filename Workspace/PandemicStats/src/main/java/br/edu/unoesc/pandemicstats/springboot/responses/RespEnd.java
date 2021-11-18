package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.Endereco;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowEndSCH;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 10/11/2021
 * @version 1.2
 * @see Endereco
 * @see ShowEndSCH
 */
@Data
public class RespEnd{
	private ShowEndSCH showend = new ShowEndSCH();
	private String erro;
	private int codstatus;
	
	/**
	 * @param Endereco endereco
	 * @param int codstatus
	 */
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
