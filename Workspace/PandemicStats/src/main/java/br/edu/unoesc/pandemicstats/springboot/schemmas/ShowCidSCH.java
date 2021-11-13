package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import br.edu.unoesc.pandemicstats.springboot.model.Estado;
import lombok.Data;

@Data
public class ShowCidSCH {
	private String nomcid;
	private long codest;
	
	public void Convert(Cidade c)
	{
		this.nomcid = c.getNomcid();
		Estado e = c.getCodest();
		this.codest = e.getCodest();
	}
}
