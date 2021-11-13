package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Cidade;
import lombok.Data;

@Data
public class ShowCidSCH {
	private String nomcid;
	private long codcid;
	
	public void Convert(Cidade cidade)
	{
		this.nomcid = cidade.getNomcid();
		this.codcid = cidade.getCodcid();
	}
}
