package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.TesteCovid;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowTesCovSCH;
import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 12/11/2021
 * @version 1.2
 * @see ShowTesCovSCH
 * @see TesteCovid
 */
@Data
public class RespTesCov {
	private ShowTesCovSCH showtescov= new ShowTesCovSCH();
	private String erro;
	private int codstatus;
	
	/**
	 * @param TesteCovid teste
	 * @param int codstatus
	 */
	public void RespValTesCov(TesteCovid teste, int codstatus)
	{
		if(codstatus==500)
		{
			this.codstatus = codstatus;
			this.erro = "Erro interno ou variável nula";
		}
		else if(codstatus==501)
		{
			this.codstatus = codstatus;
			this.erro = "Resultado invalido";
		}
	}
}
