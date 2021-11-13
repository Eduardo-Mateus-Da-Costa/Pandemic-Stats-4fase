package br.edu.unoesc.pandemicstats.springboot.schemmas;

import br.edu.unoesc.pandemicstats.springboot.model.Estado;
import br.edu.unoesc.pandemicstats.springboot.model.Pais;
import lombok.Data;

@Data
public class ShowEstSCH {
	private String nomest;
	private long codpai;
	
	public void Convert(Estado estado)
	{
		this.nomest = estado.getNomest();
		Pais pais = estado.getCodpai();
		this.codpai = pais.getCodpai();
	}
}
