package br.edu.unoesc.pandemicstats.springboot.responses;

import br.edu.unoesc.pandemicstats.springboot.model.TesteCovid;
import br.edu.unoesc.pandemicstats.springboot.schemmas.ShowTesCovSCH;
import lombok.Data;

@Data
public class RespTesCov {
	private ShowTesCovSCH showtescov= new ShowTesCovSCH();
	private String erro;
	private int codstatus;
	
	public void RespValTesCov(TesteCovid teste, int codstatus)
	{
		if(codstatus==501)
		{
			this.codstatus = codstatus;
			this.erro = "Resultado invalido";
		}
	}
}
